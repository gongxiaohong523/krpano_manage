package com.example.krpano.utils.pano.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Pano {
    public static boolean initSuccess = false;
    public static String toolsPath = "";
    public static String kmakemultires = "";
    private static SAXReader reader = new SAXReader();

    public Pano() {
    }

    public static void initPanoTool() {
        try {
            if (ResourceUtil.resourceInit()) {
                initSuccess = true;
            }
        } catch (Exception var1) {
            System.out.println(var1.getMessage());
        }

    }

    public static void main(String[] args) {
        initPanoTool();
        if (initSuccess) {
            Return r = splitScenePicture("/Users/xiaohonggong/Desktop/81594902693_.pic.jpg");
            if (r.isIsok()) {
                System.out.println(r.getMsg());
            }
        }

    }

    public static String convertImageXMLToDB(String xmlPath) throws DocumentException {
        Document document = reader.read(new File(xmlPath));
        Element krpano = document.getRootElement();
        Element image = krpano.element("scene").element("image");
        String imageXML = image.asXML();
        imageXML = imageXML.replace("url=\"panos/temp.tiles", "url=\"$abcdefg$");
        System.out.println(imageXML);
        return imageXML;
    }

    public static Return splitScenePicture(String picFileStr) {
        Return ret = new Return();
        ret.setIsok(true);
        Process process = null;
        File picFile = new File(picFileStr);
        if (!picFile.exists()) {
            ret.setMsg("目标文件不存在");
            ret.setIsok(false);
            return ret;
        } else {
            String picPath = picFile.getParent();
            File vtour = new File(picPath + "/vtour");
            System.out.println(picPath + "/vtour");
            if (vtour.exists()) {
                deleteDir(vtour);
            }

            Return var10;
            try {
                String line = null;
                process = Runtime.getRuntime().exec(toolsPath + "/kmakemultires.exe " + toolsPath + "/templates/vtour-multires.config  " + picFileStr);
                InputStream fis = process.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }

                if (process.waitFor() != 0) {
                    ret.setMsg("程序内部错误");
                    ret.setIsok(false);
                    var10 = ret;
                    return var10;
                }

                ret.setMsg(convertImageXMLToDB(picPath + "/vtour/tour.xml"));
                var10 = ret;
            } catch (Exception var13) {
                ret.setIsok(false);
                ret.setMsg(var13.getMessage());
                var10 = ret;
                return var10;
            } finally {
                process.destroy();
            }

            return var10;
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for(int i = 0; i < children.length; ++i) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
