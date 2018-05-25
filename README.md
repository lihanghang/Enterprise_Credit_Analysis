# Enterprise_Credit_Analysis
    一个集企业信息查询、数据分析、推理、评估、预测企业信用可视化分析平台
    下阶段会基于知识图谱、机器学习算法、深度神经网络进行风险评估及关联关系推理
#### 平台架构
1. 系统架构主要分为：企业信息查询模块、智能分析模块、系统后台模块、企业关系分析模块
#### 企业信息查询模块
1. 用户登录、注册
1. 数据存储包含传统关系数据库及RDF图数据库
2. 企业基本信息展示及与其他企业关系、任务关系等
#### 智能分析模块
1. 基于DEA科研投入推荐模型实现.【后台通过MATLAB进行计算，Java调用模型在系统使用】
2. 基于决策树实现企业信用等级评估模型.通过四分位图直观展示企业指标是否异常及处于行业水平位置。利用ANN网络进行评级。
3. 三大行业动态预测【全国房地产、汽车、软件信息服务业相关指数及可视化】
4. 基于DEA的企业风险模型，从财务风险、经营风险、技术风险、战略风险四维一级指标进行刻画。
5. 贷后预警模块
#### 企业关系分析模块
1. 基于RDF构建企业信息知识库
#### 系统后台模块
 1. 登录、注册  
 2. 增加后台对用户、管理员管理
 3. 数据上传接口
 4. 用户权限管理
  
***

## 问题记录

#### 
1. 远程代码至temp：git fetch origin master:temp
2. 地代码进行比较： git diff temp
3. 地代码合并：git merge temp
4. 本地 temp分支（可选）：git branch -d temp
5. 通过java调用MATLAB，进行复杂数据计算和相关算法实现。
6. 更新本地仓库代码：git pull.
7. 删除分支：git push origin : branch_name(您需要删除的分支名)。
8. java调用MATLAB封装的函数及神经网络函数。
【欢迎交流，邮箱ilihanghang@126.com】
 更新时间【2018.5.25】