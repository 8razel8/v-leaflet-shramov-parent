package org.vaadin.addon.leaflet.shramov.client;

import com.vaadin.shared.ui.Connect;
import org.peimari.gleaflet.client.Layer;
import org.peimari.gleaflet.client.shramov.YandexLayer;
import org.peimari.gleaflet.client.shramov.YandexLayerOptions;
import org.vaadin.addon.leaflet.client.AbstractLeafletLayerConnector;
import org.vaadin.addon.leaflet.shramov.LYandexLayer;

@Connect(LYandexLayer.class)
public class LeafletYandexLayerConnector extends
        AbstractLeafletLayerConnector<YandexLayerOptions> {

    protected Layer layer;

    @Override
    public LeafletYandexLayerState getState() {
        return (LeafletYandexLayerState) super.getState();
    }

    @Override
    protected YandexLayerOptions createOptions() {
        YandexLayerOptions o = YandexLayerOptions.create();
        LeafletYandexLayerState s = getState();
        // TODO add config
        return o;
    }

    @Override
    protected void update() {
        if (layer != null) {
            removeLayerFromParent();
        } else {
            YandexLayerOptions o = createOptions();
            layer = YandexLayer.create(getState().layertype, o);
        }

        addToParent(layer);
    }

    @Override
    public Layer getLayer() {
        return layer;
    }
}
