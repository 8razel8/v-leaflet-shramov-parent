package org.peimari.gleaflet.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.i18n.client.LocaleInfo;

public class LeafletShramovResourceInjector {

    protected static LeafletShramovClientBundle bundle;

    public static void ensureInjected() {
        if (bundle == null) {
            LeafletResourceInjector.ensureInjected();
            bundle = GWT.create(LeafletShramovClientBundle.class);
            LeafletShramovResourceInjector injector = GWT
                    .create(LeafletShramovResourceInjector.class);
            injector.injectResources();
        }
    }

    /**
     * Override this with deferred binding to customize injected stuff
     */
    protected void injectResources() {
        final String googleText = bundle.google().getText();
        ScriptInjector.fromString(googleText).setWindow(nativeTopWindow()).inject();

        final String bingText = bundle.bing().getText();
        ScriptInjector.fromString(bingText).setWindow(nativeTopWindow()).inject();

        final String yandexText = bundle.yandex().getText();
        String localeCode = "default".equals(LocaleInfo.getCurrentLocale().getLocaleName()) ? "ru_RU" : LocaleInfo.getCurrentLocale().getLocaleName();
        ScriptInjector.fromUrl("https://api-maps.yandex.ru/2.1/?lang=" + localeCode).setWindow(nativeTopWindow()).inject();
        ScriptInjector.fromString(yandexText).setWindow(nativeTopWindow()).inject();
    }

    private static native JavaScriptObject nativeTopWindow() /*-{
     return $wnd;
    }-*/;

}
