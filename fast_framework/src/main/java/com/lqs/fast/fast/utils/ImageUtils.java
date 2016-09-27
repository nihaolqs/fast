package com.lqs.fast.fast.utils;

import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dell on 2016/9/27.
 */

public final class ImageUtils {
    private ImageUtils(){};

    public static void LoadImage(SimpleDraweeView simpleDraweeView,Uri... uri){
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
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
    }

    public static void LoadImage(ImageView imageView, String uristr){

    }
}
