package com.googlecast;

import static com.google.android.libraries.cast.companionlibrary.utils.LogUtils.LOGD;

import com.google.android.gms.cast.CastDevice;
import com.google.android.libraries.cast.companionlibrary.utils.LogUtils;
import com.google.android.libraries.cast.companionlibrary.cast.BaseCastManager;

import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.RouteInfo;

public class GoogleCastMediaRouterCallback extends MediaRouter.Callback {
	private static final String TAG = LogUtils.makeLogTag(GoogleCastMediaRouterCallback.class);
	private final BaseCastManager mCastManager;

	public GoogleCastMediaRouterCallback(BaseCastManager castManager) {
		mCastManager = castManager;
	}

	@Override
	public void onRouteUnselected(MediaRouter router, RouteInfo routeInfo) {
	}

	@Override
	public void onRouteAdded(MediaRouter router, RouteInfo routeInfo) {
		mCastManager.onCastDeviceDetected(routeInfo);
	}

	@Override
	public void onRouteRemoved(MediaRouter router, RouteInfo route) {
	}

	@Override
	public void onRouteChanged(MediaRouter router, RouteInfo route) {
	}
}
