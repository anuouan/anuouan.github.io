# mkdocs不支持无序嵌套问题

## 1. 问题

不管是 `typora` 还是 `vscode`，都是可以正常渲染嵌套的列表的

但是 `mkdoc` 却不行，真是令人难以置信，但这确实发生了

如何解决了？

`typora`

![image-20240229160449888](2-mkdocs%E4%B8%8D%E6%94%AF%E6%8C%81%E6%97%A0%E5%BA%8F%E5%B5%8C%E5%A5%97%E9%97%AE%E9%A2%98.assets/image-20240229160449888.png)

`mkdocs网站预览`

![image-20240229160537271](2-mkdocs%E4%B8%8D%E6%94%AF%E6%8C%81%E6%97%A0%E5%BA%8F%E5%B5%8C%E5%A5%97%E9%97%AE%E9%A2%98.assets/image-20240229160537271.png)

## 2. 解决方法

安装 `mdx_truly_sane_lists` 

```bash
pip install mdx_truly_sane_lists
```

然后在 `mkdoc.yml` 的 `markdown_extensions` 添加 `mdx_truly_sane_lists` 就好了

![image-20240229160819853](2-mkdocs%E4%B8%8D%E6%94%AF%E6%8C%81%E6%97%A0%E5%BA%8F%E5%B5%8C%E5%A5%97%E9%97%AE%E9%A2%98.assets/image-20240229160819853.png)

成功示例

![image-20240229161039873](2-mkdocs%E4%B8%8D%E6%94%AF%E6%8C%81%E6%97%A0%E5%BA%8F%E5%B5%8C%E5%A5%97%E9%97%AE%E9%A2%98.assets/image-20240229161039873.png)

## 3. 相关链接

 [Mkdocs doesn't generate ordered list](https://link.segmentfault.com/?enc=PoqMCOMH2TmJDYVIFRsrJQ%3D%3D.hR7uo88xNNTYsHP0ID1PtFTFFjlRB11UqG4r3utfqECkum9EXR4pQqPunMqryXHfVbteKXq6rAvHTT0ir3Tx0x53WLTw772ZPqBONLUlSVh7M7x5vNkn0eqQPaCO0x%2B9)
