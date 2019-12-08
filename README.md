### 项目使用的技术和工具

> Mybatis plus 生成工具
* MyBatisCodeHelperPro

> 映射对象工具
* MapStruct

> yapi和生成文档插件
* yapi和YapiUpload

YapiUpload插件配置单模块项目 .idea中misc.xml添加下面内容

```xml
<component name="yapi">
  <option name="projectToken">token</option>
  <option name="projectId">id</option>
  <option name="yapiUrl">http://localhost:3000</option>
  <option name="projectType">api</option>
  <option name="attachUploadUrl">http://localhost/fileupload</option>
  <option name="returnClass">com.mxc.springbootmybatisquick.utils.ResponseView</option>
</component>
```

Alt+U选择类或者方法上传就行了

> 新建类注释模板(兼容yapi)

```bash
/**
 *@className ${NAME}
 *@description
 *@author ${USER}
 *@date ${DATE} ${TIME}
 *@menu
**/
```

> 新建方法注释(兼容yapi)

参考博客添加方法

> smart-doc文档

也可以使用smart-doc生成文档和postman请求数据 这边使用它生成postman请求数据 在test目录有例子而且可以很好的加载源码目录的注释

mybatis-plus加载源码注释例子：https://gitee.com/sunyurepository/smart-doc/wikis/第三框架源码加载配置?sort_id=1736350

文档：https://gitee.com/sunyurepository/smart-doc/wikis/Home