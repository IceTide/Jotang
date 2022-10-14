# **啥是Git**


###### 初印象：

> **问所未闻~~~**

#### 开干！

---

###### 正在前往github[^1]    

- 注册一个账号[^2]      

  <img src="1.png" width = 500>

- 试图申请学生礼包

  <img src="2.png" width = 500>

  > **失败~~~~~~（~~我哪有什么电子学生卡啊喂！！！~~）~~**~~

- 建立存储库(公有)

  <img src="3.png" width = 500>

  > **然后……**
  >
  > **然后某愚蠢(bushi)的新生发现自己点成21年的招新了(Ｔ▽Ｔ)**
  >
  > **回归正题**

  ----

###### 正在前往“本地Git操作”

<img src="4.png" width = 200>

- **Git简介（已阅）**

  > **这东西还有习题！！？**
  >
  > <img src="5.png" width = 200>

- **下载Git**[^3]**（下完）**

  <img src="6.png" width = 300> <img src="7.png" width = 300>

---

###### 时间太长，先吃个饭[^3.5]

<img src="吃饭7.5.png" width = 500>

---

- **创建版本库**

<img src="8.png" width = 600>

> **这个mkdir和cd是什么意思？？？？**
>
> **我在哪指定文件位置呢？？？**

- 上博客找资料-ing[^4]

  <img src="9.png" width = 200>

  > **打开Git Bash**
  >
  > **输入git init**
  >
  > **创建成功(￣▽￣)~***
  >
  > <img src="10.png" width = 700>
  
- **时光机**

###### 上传文件

```git
$ git add <file> // 添加
$ git commit -m "contest"  // 提交
```

<img src="11.png" width = 600>

###### 版本回溯
```git
$ git log // 版本信息
$ git log --pretty=oneline // 版本信息简化版
$ git diff <file>// 查看修改
$ git status // 查看当前状态
$ git reset --hard HEAD^ // 退回上一版本(n个^,n个版本)
$ git reflog // 显示操作记录
$ git reset --hard (版本号) // 回到某个版本
```

---

###### 激动，试图使用git管理我的md文件

> **失败 ! ! ?**
>
> **明明之前还成功的！！！**

最初我以为是我的文件名是中文的原因 —— 改成没中文也不行

然后我以为是我的父目录有中文的原因 —— 换成英文目录也不行

最后我以为是git无法管理md文件 —— 上百度查又可以[^5]

>**报着死马当活马医的原则，我删掉了文件名前面的#**
>
>**成功了……**

---

###### 回到Git教程

- 暂存区 —— get

- 管理修改 —— get

```git
$ git cheakout -- <file> // 撤销工作区中的修改
$ git reset HEAD <file> // 回到最后commit的版本
$ git reset --hard (版本号) // 回到某个版本
```

- 删除文件 —— get

```git
$ rm <file> // 删除文件
$ git rm <file> // 删除版本库中文件（需要提交）
$ git checkout -- <file> // 用工作区中文件替换成版本库版本
```

- 远程仓库
  - GitHub账号 —— **got**
  
  - 创建并添加SSH Key —— get
  
  - 创建GitHub的仓库并关联 —— get
  
    > 试图关联两个文件夹关联仓库（失败）[^op]
  
  - 远程库克隆 —— get

```git
$ git remote add <name> git @.com:<user name>/<name>.git // 关联
$ git push -u origin master // 关联并提交
$ git remote rm <name> // 删除远程库的关联
$ git remote -v // 查看远程库信息
$ git clone git@.com:<user name>/<name>.git // 克隆远程库
```

- 分支
  - 创建与删除分支
  - 解除冲突
  - Bug 分支

```git
$ git branch // 查看分支
$ git branch <name> // 创建分支
$ git checkout/switch <name> // 切换分支
$ git checkout -b <name>
$ git switch -c <name> // 创建+切换分支
$ git merge <name> // 合并到当前分支
$ git branch -d <name> // 删除分支
$ git log --graph // 查看分支图
--no-ff 禁用 fast forward 模式
$ git stash // 储存
$ git stash list // 显示工作现场
$ git stash apply // 回复stash
$ git stash drop // 删除stash
$ git stash pop // 回复并删除stash
$ git branch -D <name> // 删除分支
$ git remote -v // 查看远程仓库
$ git checkout -b dev origin/dev // 建立分支
$ git branch --set-upstream-to=origin/dev dev // 设置dev和origin/dev的链接
$ git pull // 拉取远程库 
$ git rebase // 把分叉的提交历史“整理”成一条直线
```



---

###### 吃个饭换个教程下饭

> **git 的指令有点搞不懂，去知乎上搜了搜教程**
>
> **以下为成果：**

- 搞了搞颜色
- 搞了搞简写（别名）

<img src="12.png" width = 500>

> 吃饭结束

---

###### SourceTree

- 下载

<img src="13.png" width = 500>

- 使用

<img src="14.png" width = 500>

---

###### GitHub Page

- 成功构建

<img src="15.png" width =  500>





---

[^1]: 我点成21年的招新了o(╥﹏╥)o    
[^2]: 个性化全部跳过    
[^3]: 下载时间过长先去学了Markdown  
[^3.5]: 看个下饭视频
[^4]: 终于找到了代替方法
[^5]: 还学习搭建了一下GitHub Desktop  
[^op]: 寻找原因中

