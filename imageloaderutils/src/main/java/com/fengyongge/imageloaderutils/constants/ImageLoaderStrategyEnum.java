package com.fengyongge.imageloaderutils.constants;

/**
 * describe
 * 底层图片加载策略枚举
 * @author fengyongge
 * @data 2020/11/2
 */
public enum ImageLoaderStrategyEnum {
     /**
      * glde
      */
     GLIDE("glde"),
     /**
      * universal_image_loader
      */
     UNIVERSAL_IMAGE_LOADER("universal_image_loader"),
     /**
      * fress
      */
     FRESSO("fress"),
     /**
      * picasso
      */
     PICASSO("picasso");
     private String action;

     ImageLoaderStrategyEnum(String action) {
          this.action = action;
     }

     public String getAction() {
          return action;
     }
}
