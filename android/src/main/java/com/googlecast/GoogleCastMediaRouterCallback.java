package com.googlecast;

import static com.google.android.libraries.cast.companionlibrary.utils.LogUtils.LOGD;

import com.google.android.gms.cast.CastDevice;
import com.google.android.libraries.cast.companionlibrary.utils.LogUtils;
import com.google.android.libraries.cast.companionlibrary.cast.BaseCastManager;
import com.facebook.react.common.annotations.VisibleForTesting;

import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.util.Log;

public class GoogleCastMediaRouterCallback extends MediaRouter.Callback {
	private static final String TAG = LogUtils.makeLogTag(GoogleCastMediaRouterCallback.class);
	private final BaseCastManager mCastManager;
	@VisibleForTesting
	public static final String REACT_CLASS = "GoogleCastMediaRouterCallback";

	public GoogleCastMediaRouterCallback(BaseCastManager castManager) {
		mCastManager = castManager;
	}

	@Override
	public void onRouteUnselected(MediaRouter router, RouteInfo routeInfo) {
		Log.e(REACT_CLASS, "onRouteUnselected id:" + routeInfo.getId() + " name:" + routeInfo.getName());
	}

	@Override
	public void onRouteAdded(MediaRouter router, RouteInfo routeInfo) {
		Log.e(REACT_CLASS, "onRouteAdded id:" + routeInfo.getId() + " name:" + routeInfo.getName());
		mCastManager.onCastDeviceDetected(routeInfo);
	}

	@Override
	public void onRouteRemoved(MediaRouter router, RouteInfo route) {
		Log.e(REACT_CLASS, "onRouteRemoved id:" + route.getId() + " name:" + route.getName());
	}

	@Override
	public void onRouteChanged(MediaRouter router, RouteInfo route) {
		Log.e(REACT_CLASS, "onRouteChanged id:" + route.getId() + " name:" + route.getName());
		if (route.isEnabled()) {
			mCastManager.onCastDeviceDetected(route);
		}
	}
}
