# spring-demo

#### 介绍
spring-demo项目通过nacos管理配置，实现动态刷新

#### 软件架构
软件架构说明
https://www.tapd.cn/62774055/documents/file_list/1162774055001000006


#### 安装教程
1.  安装springcloud-nacos/doc/jar包目录下的jar包到本地仓库
2.  将springcloud-nacos/doc下bootstrap-dev.yml文件在nacos管理平台上创建并录入该文档中的内容，修改其mysql数据库链接
3.  修改springcloud-nacos工程springcloud-nacos配置文件，切换打包方式，本地开发使用dev
4.  清空、编译、打包、安装springcloud-nacos工程到本地仓库，所有项目提示success，即安装成功

#### 使用说明
1.  安装完成后，选择项目springcloud-nacos启动类 SpringDemoApplication，右键直接run即可
2.  启动成功后，直接访问swagger接口查看 http://localhost:8093/demo/swagger-ui.html
3.  项目中docker打包请参考：https://starsky.blog.csdn.net/article/details/118155013

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
