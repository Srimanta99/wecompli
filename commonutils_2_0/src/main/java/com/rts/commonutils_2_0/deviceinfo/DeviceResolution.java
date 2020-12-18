package com.rts.commonutils_2_0.deviceinfo;

import android.app.Activity;
import android.graphics.Typeface;

import android.util.DisplayMetrics;

public class DeviceResolution {

    private int mHeight, mWidth;
    private double mScreenInches;
    private Activity mActivity;
    public Typeface typefaceRegular,typefacemedium,
            typefaceSemiBold, typefaceBold, typeLight, typeThin,frutigerltw75black,frutigerltw55roman,whitneybold,whitneybook,
            whitneybookitalic,whitneylight,whitneylightitalic,whitneymedium,whitneymediumitalic,whitneysemibold, WhitneySemiboldItalic;

    public DeviceResolution(Activity activity) {
        this.mActivity = activity;
        getDeviceResolution();
       // initializeTypeface(activity);
    }

    private void getDeviceResolution() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mHeight = displaymetrics.heightPixels;
        mWidth = displaymetrics.widthPixels;

        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(mWidth / dm.xdpi, 2);
        double y = Math.pow(mHeight / dm.ydpi, 2);

        mScreenInches = Math.sqrt(x + y);

        if (mWidth <= 480 && mScreenInches > 5.0) {
            mScreenInches = 4.5;
        }
    }

   /* public void initializeTypeface(Activity activity) {
        typefacemedium=Typeface.createFromAsset(activity.getAssets(), "font/Roboto-Medium.ttf");
        typefaceRegular = Typeface.createFromAsset(activity.getAssets(), "font/Roboto-Regular.ttf");
        typefaceSemiBold = Typeface.createFromAsset(activity.getAssets(), "font/Roboto-Medium.ttf");
        typefaceBold = Typeface.createFromAsset(activity.getAssets(), "font/Roboto-Bold.ttf");
        typeLight = Typeface.createFromAsset(activity.getAssets(), "font/Roboto-Light.ttf");
        typeThin = Typeface.createFromAsset(activity.getAssets(), "font/Roboto-Thin.ttf");
        frutigerltw75black=Typeface.createFromAsset(activity.getAssets(),"font/frutigerltw20-75black.ttf");
        frutigerltw55roman=Typeface.createFromAsset(activity.getAssets(),"font/frutigerltw20-55roman.ttf");
    }*/

    public Typeface getgothmbold(Activity activity){
        frutigerltw75black=Typeface.createFromAsset(activity.getAssets(),"font/Gotham-Bold.otf");
        return frutigerltw75black;

    }
    public Typeface getgothmlight(Activity activity){
        frutigerltw55roman=Typeface.createFromAsset(activity.getAssets(),"font/Gotham-Light.otf");
        return frutigerltw55roman;

    }

    public Typeface getgothamthin(Activity activity){
        frutigerltw55roman=Typeface.createFromAsset(activity.getAssets(),"font/Gotham-Thin.otf");
        return frutigerltw55roman;

    }
    public Typeface getgothmXlight(Activity activity){
        frutigerltw55roman=Typeface.createFromAsset(activity.getAssets(),"font/Gotham-XLight.otf");
        return typefacemedium;

    }
    public Typeface getbebas(Activity activity){
        frutigerltw55roman=Typeface.createFromAsset(activity.getAssets(),"font/BEBAS.ttf");
        return frutigerltw55roman;

    }

    public Typeface getwhitneybold(Activity activity){
        whitneybold=Typeface.createFromAsset(activity.getAssets(),"font/whitneybold.otf");
        return whitneybold;

    }
    public Typeface getwhitneybook(Activity activity){
        whitneybook=Typeface.createFromAsset(activity.getAssets(),"font/whitneybook.otf");
        return whitneybook;

    }

    public Typeface gewhitneybookitalic(Activity activity){
        whitneybookitalic=Typeface.createFromAsset(activity.getAssets(),"font/whitneybookitalic.otf");
        return whitneybookitalic;

    }
    public Typeface getwhitneylight(Activity activity){
        whitneylight=Typeface.createFromAsset(activity.getAssets(),"font/whitneylight.otf");
        return whitneylight;

    }
    public Typeface getwhitneylightitalic(Activity activity){
        whitneylightitalic=Typeface.createFromAsset(activity.getAssets(),"font/whitneylightitalic.otf");
        return whitneylightitalic;

    }

    public Typeface getwhitneymedium(Activity activity){
        whitneymedium=Typeface.createFromAsset(activity.getAssets(),"font/whitneymedium.otf");
        return whitneymedium;

    }

    public Typeface gewhitneymediumitalic(Activity activity){
        whitneymediumitalic=Typeface.createFromAsset(activity.getAssets(),"font/whitneymediumitalic.otf");
        return whitneymediumitalic;

    }
    public Typeface getwhitneysemibold(Activity activity){
        whitneysemibold=Typeface.createFromAsset(activity.getAssets(),"font/whitneysemibold.otf");
        return whitneysemibold;

    }
    public Typeface getWhitneySemiboldItalic(Activity activity){
        WhitneySemiboldItalic=Typeface.createFromAsset(activity.getAssets(),"font/WhitneySemiboldItalic.otf");
        return WhitneySemiboldItalic;

    }


    public int getHeight(double heightVal) {
        return (int) (mHeight * heightVal);
    }

    public int getWidth(double widthVal) {
        return (int) (mWidth * widthVal);
    }

    public float getTextSize(double textSize) {
        return (float) (mScreenInches * textSize);
    }

}
