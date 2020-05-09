goog.provide('stylefy.impl.utils');
goog.require('cljs.core');
goog.require('dommy.core');
goog.require('garden.core');
goog.require('garden.color');
goog.require('garden.types');
goog.require('garden.stylesheet');
goog.require('clojure.string');
/**
 * Removes stylefy's namespaced keywords from the given map.
 */
stylefy.impl.utils.filter_css_props = (function stylefy$impl$utils$filter_css_props(props){
return cljs.core.apply.cljs$core$IFn$_invoke$arity$3(cljs.core.dissoc,props,cljs.core.filter.cljs$core$IFn$_invoke$arity$2((function (p1__37770_SHARP_){
var and__4109__auto__ = cljs.core.namespace(p1__37770_SHARP_);
if(cljs.core.truth_(and__4109__auto__)){
return clojure.string.starts_with_QMARK_(cljs.core.namespace(p1__37770_SHARP_),"stylefy");
} else {
return and__4109__auto__;
}
}),cljs.core.keys(props)));
});
stylefy.impl.utils.is_garden_value_QMARK_ = (function stylefy$impl$utils$is_garden_value_QMARK_(value){
return (((value instanceof garden.types.CSSUnit)) || ((value instanceof garden.color.CSSColor)) || ((value instanceof garden.types.CSSFunction)));
});

//# sourceMappingURL=stylefy.impl.utils.js.map
