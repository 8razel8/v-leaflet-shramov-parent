package org.peimari.gleaflet.client.shramov;

import org.peimari.gleaflet.client.Layer;
import org.peimari.gleaflet.client.resources.LeafletShramovResourceInjector;

/**
 * Note, that to use this feature, one must somehow add Yandex Maps scripts to
 * the host page.
 *
 * @author Ivan I. Nakonechnyi
 */
public class YandexLayer extends Layer {

    static {
        LeafletShramovResourceInjector.ensureInjected();
    }

    public enum Type {
        SATELLITE, ROADMAP, HYBRID, TERRAIN
    }

    protected YandexLayer() {
    }

    public static YandexLayer create(Type type, YandexLayerOptions options) {
        return create(type.toString(), options);
    }

    public static native YandexLayer create(String type, YandexLayerOptions options)/*-{
        return new $wnd.L.Yandex(type, options);
    }-*/;

}
