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

使用idea插件 EasyJavadoc 导入配置好的模板 easy_javadoc.json 点击方法/类使用command + \ 生成注释 更多功能参考官网 点击中文可以生成英文驼峰

> smart-doc文档

暂时使用smart-doc生成postman请求例子 smart-doc生成文档并不好用推荐使用yapi 建议使用maven插件生成

> Diboot自动化开发框架

封装了通用的mybatis-plus查询条件 返回分页转换vo返回多表关联的数据 绑定数据字典枚举 比如gender=M显示M对应的性别

使用教程：https://www.diboot.com/guide/diboot-core/%E5%AE%89%E8%A3%85.html