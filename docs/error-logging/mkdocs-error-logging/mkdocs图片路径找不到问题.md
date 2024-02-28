# mkdocs图片路径找不到问题

## 1. 问题

.md文件插入图片在mkdocs网站中无法显示，找不到路径404问题

`图片路径：`

```java
<img src="QQ%E7%95%99%E8%A8%80.assets/d582c07eb6c69c8e364c540f6319210.jpg" alt="d582c07eb6c69c8e364c540f6319210" style="zoom:33%;" />
```

## 2. 效果显示

`控制台：`

<img src="mkdocs%E5%9B%BE%E7%89%87%E8%B7%AF%E5%BE%84%E6%89%BE%E4%B8%8D%E5%88%B0%E9%97%AE%E9%A2%98.assets/image-20240228234532858.png" alt="image-20240228234532858" style="zoom: 67%;" />

`typora`

<img src="mkdocs%E5%9B%BE%E7%89%87%E8%B7%AF%E5%BE%84%E6%89%BE%E4%B8%8D%E5%88%B0%E9%97%AE%E9%A2%98.assets/image-20240228234618684.png" alt="image-20240228234618684" style="zoom: 67%;" />

`部署到mkdocs网站`

<img src="mkdocs%E5%9B%BE%E7%89%87%E8%B7%AF%E5%BE%84%E6%89%BE%E4%B8%8D%E5%88%B0%E9%97%AE%E9%A2%98.assets/image-20240228234748555.png" alt="image-20240228234748555" style="zoom:67%;" />

## 3. 解决办法

根据网上查找和自己琢磨，官网解释如下：

<img src="mkdocs%E5%9B%BE%E7%89%87%E8%B7%AF%E5%BE%84%E6%89%BE%E4%B8%8D%E5%88%B0%E9%97%AE%E9%A2%98.assets/image-20240228235002319.png" alt="image-20240228235002319" style="zoom: 50%;" />

通过资料查找在mkdocs.yaml文件添加`use_directory_urls: false`这个配置就能成功显示了

```java
# 解决markdown中使用原生的html缩放图片，在mkdocs网站上报错404不显示
use_directory_urls: false
```

`成功示例图`

<img src="mkdocs%E5%9B%BE%E7%89%87%E8%B7%AF%E5%BE%84%E6%89%BE%E4%B8%8D%E5%88%B0%E9%97%AE%E9%A2%98.assets/image-20240228235128816.png" alt="image-20240228235128816" style="zoom: 50%;" />
