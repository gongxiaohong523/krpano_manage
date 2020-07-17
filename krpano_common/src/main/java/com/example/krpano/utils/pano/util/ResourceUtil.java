package com.example.krpano.utils.pano.util;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceUtil {
    public ResourceUtil() {
    }

    public static boolean resourceInit() {
        try {
            String base = (new File("")).getCanonicalPath() + "/kbacdp/";
            Pano.toolsPath =  StringUtils.removeEndIgnoreCase(base,"/");
            File f = new File(base);
            if (f.exists()) {
                f.delete();
            }

            Copy("/pano/convertdroplets.config", base, "convertdroplets.config");
            Copy("/pano/kcube2sphere.exe", base, "kcube2sphere.exe");
            Copy("/pano/kencrypt.exe", base, "kencrypt.exe");
            Copy("/pano/kmakemultires.exe", base, "kmakemultires.exe");
            Copy("/pano/kmakepreview.exe", base, "kmakepreview.exe");
            Copy("/pano/kmaketiles.exe", base, "kmaketiles.exe");
            Copy("/pano/kprotectcl.exe", base, "kprotectcl.exe");
            Copy("/pano/krpano Protect Tool.exe", base, "krpano Protect Tool.exe");
            Copy("/pano/krpano Update Tool.exe", base, "krpano Update Tool.exe");
            Copy("/pano/krpano.license", base, "krpano.license");
            Copy("/pano/krpano.swf", base, "krpano.swf");
            Copy("/pano/krpanobrandingfree.license", base, "krpanobrandingfree.license");
            Copy("/pano/krpanoiphone.js", base, "krpanoiphone.js");
            Copy("/pano/krpanoiphone.license.js", base, "krpanoiphone.license.js");
            Copy("/pano/krpanotools.license", base, "krpanotools.license");
            Copy("/pano/ktransform.exe", base, "ktransform.exe");
            Copy("/pano/swfkrpano.js", base, "swfkrpano.js");
            Copy("/pano/templates/basicsettings.config", base + "/templates", "basicsettings.config");
            Copy("/pano/templates/defaultbuttons.skin", base + "/templates", "defaultbuttons.skin");
            Copy("/pano/templates/flat.config", base + "/templates", "flat.config");
            Copy("/pano/templates/multiframe.config", base + "/templates", "multiframe.config");
            Copy("/pano/templates/multires.config", base + "/templates", "multires.config");
            Copy("/pano/templates/normal.config", base + "/templates", "normal.config");
            Copy("/pano/templates/object.config", base + "/templates", "object.config");
            Copy("/pano/templates/panoonly.skin", base + "/templates", "panoonly.skin");
            Copy("/pano/templates/singleswf-multires.config", base + "/templates", "singleswf-multires.config");
            Copy("/pano/templates/singleswf.config", base + "/templates", "singleswf.config");
            Copy("/pano/templates/vtour-multires.config", base + "/templates", "vtour-multires.config");
            Copy("/pano/templates/vtour-normal.config", base + "/templates", "vtour-normal.config");
            Copy("/pano/templates/vtourskin-comboboxes.skin", base + "/templates", "vtourskin-comboboxes.skin");
            Copy("/pano/templates/vtourskin-scrolling-thumbnails-bingmaps-gyro.skin", base + "/templates", "vtourskin-scrolling-thumbnails-bingmaps-gyro.skin");
            Copy("/pano/templates/vtourskin-stacking-thumbnails.skin", base + "/templates", "vtourskin-stacking-thumbnails.skin");
            Copy("/pano/templates/html/swfkrpano-inline-js-singleswf.html", base + "/templates/html", "swfkrpano-inline-js-singleswf.html");
            Copy("/pano/templates/html/swfkrpano.html", base + "/templates/html", "swfkrpano.html");
            Copy("/pano/templates/html/swfkrpano.js", base + "/templates/html", "swfkrpano.js");
            Copy("/pano/templates/html/tour_editor.html", base + "/templates/html", "tour_editor.html");
            Copy("/pano/templates/html/embedpano.html", base + "/templates/html", "embedpano.html");
            Copy("/pano/templates/xml/default.xml", base + "/templates/xml", "default.xml");
            Copy("/pano/templates/xml/flat.xml", base + "/templates/xml", "flat.xml");
            Copy("/pano/templates/xml/krpano_default_flares.jpg", base + "/templates/xml", "krpano_default_flares.jpg");
            Copy("/pano/templates/xml/multiframe.xml", base + "/templates/xml", "multiframe.xml");
            Copy("/pano/templates/xml/object.xml", base + "/templates/xml", "object.xml");
            Copy("/pano/templates/xml/panoonly.xml", base + "/templates/xml", "panoonly.xml");
            Copy("/pano/templates/xml/qtvr_style_skin.xml", base + "/templates/xml", "qtvr_style_skin.xml");
            Copy("/pano/templates/xml/vtour_comboboxes.xml", base + "/templates/xml", "vtour_comboboxes.xml");
            Copy("/pano/templates/xml/vtour_hotspotexample.xml", base + "/templates/xml", "vtour_hotspotexample.xml");
            Copy("/pano/templates/xml/vtour_hotspottemplate.xml", base + "/templates/xml", "vtour_hotspottemplate.xml");
            Copy("/pano/templates/xml/vtour_scenetemplate.xml", base + "/templates/xml", "vtour_scenetemplate.xml");
            Copy("/pano/templates/xml/vtour_stackingthumbnails.xml", base + "/templates/xml", "vtour_stackingthumbnails.xml");
            Copy("/pano/templates/xml/vtour_viewtemplate.xml", base + "/templates/xml", "vtour_viewtemplate.xml");
            Copy("/pano/templates/xml/vtour.xml", base + "/templates/xml", "vtour.xml");
            Copy("/pano/templates/xml/hotspots/hotspot_ani_black_64x64x20.png", base + "/templates/xml/hotspots", "hotspot_ani_black_64x64x20.png");
            Copy("/pano/templates/xml/hotspots/hotspot_ani_white_64x64x20.png", base + "/templates/xml/hotspots", "hotspot_ani_white_64x64x20.png");
            Copy("/pano/templates/xml/hotspots/hotspotstyles.xml", base + "/templates/xml/hotspots", "hotspotstyles.xml");
            Copy("/pano/templates/xml/hotspots/Thumbs.db", base + "/templates/xml/hotspots", "Thumbs.db");
            Copy("/pano/templates/xml/plugins/bingmaps.js", base + "/templates/xml/plugins", "bingmaps.js");
            Copy("/pano/templates/xml/plugins/bingmaps.swf", base + "/templates/xml/plugins", "bingmaps.swf");
            Copy("/pano/templates/xml/plugins/combobox.js", base + "/templates/xml/plugins", "combobox.js");
            Copy("/pano/templates/xml/plugins/combobox.swf", base + "/templates/xml/plugins", "combobox.swf");
            Copy("/pano/templates/xml/plugins/compass.js", base + "/templates/xml/plugins", "compass.js");
            Copy("/pano/templates/xml/plugins/editor.swf", base + "/templates/xml/plugins", "editor.swf");
            Copy("/pano/templates/xml/plugins/googlemaps.swf", base + "/templates/xml/plugins", "googlemaps.swf");
            Copy("/pano/templates/xml/plugins/gyro.js", base + "/templates/xml/plugins", "gyro.js");
            Copy("/pano/templates/xml/plugins/moretweentypes.js", base + "/templates/xml/plugins", "moretweentypes.js");
            Copy("/pano/templates/xml/plugins/moretweentypes.swf", base + "/templates/xml/plugins", "moretweentypes.swf");
            Copy("/pano/templates/xml/plugins/options.swf", base + "/templates/xml/plugins", "options.swf");
            Copy("/pano/templates/xml/plugins/radar.js", base + "/templates/xml/plugins", "radar.js");
            Copy("/pano/templates/xml/plugins/radar.swf", base + "/templates/xml/plugins", "radar.swf");
            Copy("/pano/templates/xml/plugins/scrollarea.js", base + "/templates/xml/plugins", "scrollarea.js");
            Copy("/pano/templates/xml/plugins/scrollarea.swf", base + "/templates/xml/plugins", "scrollarea.swf");
            Copy("/pano/templates/xml/plugins/snow.js", base + "/templates/xml/plugins", "snow.js");
            Copy("/pano/templates/xml/plugins/snow.swf", base + "/templates/xml/plugins", "snow.swf");
            Copy("/pano/templates/xml/plugins/soundinterface.js", base + "/templates/xml/plugins", "soundinterface.js");
            Copy("/pano/templates/xml/plugins/soundinterface.swf", base + "/templates/xml/plugins", "soundinterface.swf");
            Copy("/pano/templates/xml/plugins/textfield.swf", base + "/templates/xml/plugins", "textfield.swf");
            Copy("/pano/templates/xml/plugins/videoplayer.js", base + "/templates/xml/plugins", "videoplayer.js");
            Copy("/pano/templates/xml/plugins/videoplayer.swf", base + "/templates/xml/plugins", "videoplayer.swf");
            Copy("/pano/templates/xml/plugins/vtoureditor.swf", base + "/templates/xml/plugins", "vtoureditor.swf");
            Copy("/pano/templates/xml/skin/androidbuttons.png", base + "/templates/xml/skin", "androidbuttons.png");
            Copy("/pano/templates/xml/skin/androidskin.xml", base + "/templates/xml/skin", "androidskin.xml");
            Copy("/pano/templates/xml/skin/arrow.png", base + "/templates/xml/skin", "arrow.png");
            Copy("/pano/templates/xml/skin/black.png", base + "/templates/xml/skin", "black.png");
            Copy("/pano/templates/xml/skin/buttons.jpg", base + "/templates/xml/skin", "buttons.jpg");
            Copy("/pano/templates/xml/skin/buttons.png", base + "/templates/xml/skin", "buttons.png");
            Copy("/pano/templates/xml/skin/defaultskin.xml", base + "/templates/xml/skin", "defaultskin.xml");
            Copy("/pano/templates/xml/skin/drag-cursors.png", base + "/templates/xml/skin", "drag-cursors.png");
            Copy("/pano/templates/xml/skin/flatskin.xml", base + "/templates/xml/skin", "flatskin.xml");
            Copy("/pano/templates/xml/skin/multiframeskin.xml", base + "/templates/xml/skin", "multiframeskin.xml");
            Copy("/pano/templates/xml/skin/objectskin.xml", base + "/templates/xml/skin", "objectskin.xml");
            Copy("/pano/templates/xml/skin/qtvr-bar.png", base + "/templates/xml/skin", "qtvr-bar.png");
            Copy("/pano/templates/xml/skin/qtvr-cursors.png", base + "/templates/xml/skin", "qtvr-cursors.png");
            Copy("/pano/templates/xml/skin/vtourskin_comboboxes.xml", base + "/templates/xml/skin", "vtourskin_comboboxes.xml");
            Copy("/pano/templates/xml/skin/vtourskin_hotspot.png", base + "/templates/xml/skin", "vtourskin_hotspot.png");
            Copy("/pano/templates/xml/skin/vtourskin_mapspot.png", base + "/templates/xml/skin", "vtourskin_mapspot.png");
            Copy("/pano/templates/xml/skin/vtourskin_mapspotactive.png", base + "/templates/xml/skin", "vtourskin_mapspotactive.png");
            Copy("/pano/templates/xml/skin/vtourskin_stackingthumbs.xml", base + "/templates/xml/skin", "vtourskin_stackingthumbs.xml");
            Copy("/pano/templates/xml/skin/vtourskin_thumbborder.png", base + "/templates/xml/skin", "vtourskin_thumbborder.png");
            Copy("/pano/templates/xml/skin/vtourskin.png", base + "/templates/xml/skin", "vtourskin.png");
            Copy("/pano/templates/xml/skin/vtourskin.xml", base + "/templates/xml/skin", "vtourskin.xml");
            Copy("/pano/Convert CUBE to SPHERE droplet.bat", base, "Convert CUBE to SPHERE droplet.bat");
            Copy("/pano/Convert SPHERE to CUBE droplet.bat", base, "Convert SPHERE to CUBE droplet.bat");
            Copy("/pano/MAKE OBJECT droplet.bat", base, "MAKE OBJECT droplet.bat");
            //Copy("/pano/vtourskin.png", base, "vtourskin.png");
            //Copy("/pano/vtourskin.xml", base, "vtourskin.xml");
        } catch (Exception var2) {
            System.out.println(var2.getMessage());
        }

        return true;
    }

    public static boolean Copy(String resourceFile, String saveFilePathStr, String saveFileName) {
        boolean isDone = true;
        InputStream inputStream = ResourceUtil.class.getResourceAsStream(resourceFile);
        FileOutputStream outputStream = null;

        try {
            File saveFilePath = new File(saveFilePathStr);
            if (!saveFilePath.exists()) {
                saveFilePath.mkdirs();
            }

            outputStream = new FileOutputStream(new File(saveFilePathStr + "/" + saveFileName));
            byte[] bytes = new byte[1024];
            int read;
            while((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException var21) {
            var21.printStackTrace();
            isDone = false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException var20) {
                    var20.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException var19) {
                    var19.printStackTrace();
                }
            }

        }
        return isDone;
    }
}
