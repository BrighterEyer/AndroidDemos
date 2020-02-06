# 百度定位官方Demo

本工程主要是对百度定位官方demo的一些配置。

## 下载Demo代码
地址：http://lbsyun.baidu.com/index.php?title=android-locsdk/geosdk-android-download

下载完成，解压，选择代码文件：
![选择代码文件][1]

```
BaiduLoc_AndroidSDK_v7.2_All\BaiduLoc_AndroidSDK_v7.2_Demo\android_studio\BaiduLocDemo
```

## 使用AndroidStudio导入工程

## 申请api-key

百度api-key是与签名文件和包名绑定的，所以我们需要先获取签名文件，默认debug模式下，我们使用的签名文件是`~/.android/debug.keystore`，即用户目录下的`.android/debug.keystore`文件，其密码默认都是**android**。使用命令`keytool -list -v -keystore debug.keystore`，根据提示输入密码后，可以获取到该签名文件的SHA1的值。将SHA1值和包名`com.baidu.baidulocationdemo`填入后，可以获取到AK(api-key)值。参考：http://lbsyun.baidu.com/apiconsole/key

![获取SHA1值][2]

然后，在AndroidManifest.xml文件中，将申请到的AK值写在name为`com.baidu.lbsapi.API_KEY`的meta-data的value字段中。

![设置AK值][3]

为了更方便一些，避免因为设备变化导致签名文件不同，可以将签名文件`debug.keystore`拷贝到代码版本库中:`app/.debug.keystore`，并在app/build.gradle文件中指定debug签名文件为该文件:

![设置签名文件][4]

```
    signingConfigs {
        debug {
            storeFile file('./debug.keystore')
        }
    }
```

这样的话，我们调试运行的时候，就不会选择~/.android/debug.keystore文件，而是使用app/debug.keystore文件作为签名文件。这样就使得该工程在**任意设备**上运行，都使用相同的签名文件，即AK也就不用修改了。如果开发者想自己设置AK值，则只需要替换自己的debug.keystore文件和申请的AK值即可。

同理，我们也可以采用这种方式设置release签名文件。需要注意的是代码混淆的问题。

## 运行程序

源代码github地址：

https://github.com/YoungBear/BaiduLocDemo


  [1]: http://img.blog.csdn.net/20171201140020353?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTmV4dF9TZWNvbmQ=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast
  [2]: http://img.blog.csdn.net/20171201140133572?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTmV4dF9TZWNvbmQ=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast
  [3]: http://img.blog.csdn.net/20171201140236046?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTmV4dF9TZWNvbmQ=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast
  [4]: http://img.blog.csdn.net/20171201140316164?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTmV4dF9TZWNvbmQ=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast