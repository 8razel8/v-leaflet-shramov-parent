package org.vaadin.addon.leaflet.shramov;

import com.vividsolutions.jts.geom.Geometry;
import org.vaadin.addon.leaflet.AbstractLeafletLayer;
import org.vaadin.addon.leaflet.shramov.client.LeafletYandexLayerState;

/**
 * Provides Yandex Maps layers.
 *
 * @author Ivan I. Nakonechnyi
 */
public class LYandexLayer extends AbstractLeafletLayer {
    public enum Type {
        SATELLITE("satelite"),
        MAP("map"),
        HYBRID("hybrid"),
        PUBLIC("publicMap"),
        PUBLIC_HYBRID("publicMapHybrid");
        private String yandexName;

        Type(String yandexName) {
            this.yandexName = yandexName;
        }

        public String getYandexName() {
            return yandexName;
        }
    }

    private Type type = Type.MAP;

    public LYandexLayer() {

    }

    public LYandexLayer(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
        markAsDirty();
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        getState().layertype = type.getYandexName();
        super.beforeClientResponse(initial);
    }

    @Override
    protected LeafletYandexLayerState getState() {
        return (LeafletYandexLayerState) super.getState();
    }

    @Override
    public Geometry getGeometry() {
        return null;
    }
}
