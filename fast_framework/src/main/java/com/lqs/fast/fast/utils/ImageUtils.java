package com.lqs.fast.fast.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dell on 2016/9/27.
 */

public final class ImageUtils {

    private static ImageLoader sImageLoader;
    private static DisplayImageOptions sDisplayImageOptions;

    private ImageUtils(){};  //不需要实例化工具类

    private static boolean isInitFresco;
    private static boolean isInitUIL;

    public static void initFresco(Context context){  //默认初始化方式
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                .setDownsampleEnabled(true)   //开启向下采样图片缩放
                .build();
        initFresco(context,config);
    }

    public static void initFresco(Context context,ImagePipelineConfig config)  //预留更多接定制方式初始化
    {
        Fresco.initialize(context,config);
        isInitFresco = true;
    }
    public static void LoadImage(SimpleDraweeView simpleDraweeView,Uri... uri){
        if(!isInitFresco)
        {
            Log.e("Fresco错误","Fresco没有进行初始化");
            return;
        }
        int width = simpleDraweeView.getWidth();
        int height = simpleDraweeView.getHeight();
        ImageRequest[] requests = new ImageRequest[uri.length];
        for (int i = 0;i < uri.length;i++) {
            requests[i] = ImageRequestBuilder.newBuilderWithSource(uri[i])
                    .setProgressiveRenderingEnabled(true)  //渐进式图片
                    .setAutoRotateEnabled(true)   //自动旋转
                    .setResizeOptions(new ResizeOptions(width, height)) //根据控件大小进行缩放
                    .build();
        }

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setFirstAvailableImageRequests(requests)    //加载第一可用图片
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
    }

    public static void LoadImage(SimpleDraweeView simpleDraweeView,String... uristr)
    {
        Uri[] uris = new Uri[uristr.length];
        for (int i = 0; i< uristr.length; i++)
        {
            uris[i] = Uri.parse(uristr[i]);
        }
        LoadImage(simpleDraweeView,uris);
    }

    public static void LoadImage(SimpleDraweeView simpleDraweeView,ImageRequest request){  //需要更多自定义修改的方法
        if(!isInitFresco)
        {
            Log.e("Fresco错误","Fresco没有进行初始化");
            return;
        }
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
    }



    //UIL方式下载图片

    public static void initUIL(Context context)  //默认初始化方式
    {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
//                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions   内存保存的图片最大分辨率
//                .diskCacheExtraOptions(480, 800, null)   //磁盘保存的图片最大分辨率
                .denyCacheImageMultipleSizesInMemory() //缓存不同大小的图片
                .diskCacheSize(50 * 1024 * 1024)  // 磁盘缓存大小50M
                .diskCacheFileCount(100)  //缓存文件数量
                .writeDebugLogs()
        .build();
        initUIL(context,config);
    }

    public static void initUIL(Context context,ImageLoaderConfiguration config)   //预留传入更多选项的入口
    {
        sImageLoader = ImageLoader.getInstance();
        sImageLoader.init(config);
        isInitUIL = true;
    }

    public static void LoadImage(ImageView imageView, String uristr){
        if(!isInitUIL) {
            Log.d("UIL错误", "UIL没有进行初始化");
            return;
        }
        if(sDisplayImageOptions == null) {
            sImageLoader.displayImage(uristr, imageView);
        }else{
            sImageLoader.displayImage(uristr,imageView, sDisplayImageOptions);
        }
    }

    public static void LoadImage(ImageView imageView, String uristr, DisplayImageOptions options){
        if(!isInitUIL) {
            Log.d("UIL错误", "UIL没有进行初始化");
            return;
        }
        sImageLoader.displayImage(uristr,imageView, options);
    }

    public static void setDisplayImageOptions(DisplayImageOptions options)  //设置全局的DisplayImageOptions
    {
        sDisplayImageOptions = options;
    }
}
