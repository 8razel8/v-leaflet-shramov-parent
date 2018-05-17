package org.peimari.gleaflet.client.shramov;

import com.google.gwt.core.client.JavaScriptObject;

public class YandexLayerOptions extends JavaScriptObject {

    protected YandexLayerOptions() {
    }

    public static YandexLayerOptions create() {
        return (YandexLayerOptions) JavaScriptObject.createObject();
    }
}
