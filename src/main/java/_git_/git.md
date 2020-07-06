

# git


## 获得git仓库

    1、本地初始化一个
    2、从远程克隆
    
### 从本地初始化

    新建 总目录
    建立子目录
    
    创建空仓库
    git init // 本地一个git 空仓库
    
### 从远程仓库克隆

    在目录下
    git colne https//*****.git
    
## 工作目录、暂存区、版本库

    版本库     .git 隐藏文件假就是版本库，储存了配置、日志、和文件版本信息。
    工作目录    包含.git 的文件目录 ，存放的是开发的文件
    暂存区     .git 中 index文件就是暂存区 （stage） , 临时保存修改文件的地方
    
    工作区 -> git add -> 暂存区 -> git commit -> 版本库
    
### 工作目录 下文件两种状态

    未跟踪 （未纳入版本控制）
    已跟踪 （已纳入版本控制）
        
        已跟踪
            未修改状态
            已修改状态
            已暂存状态
            
            
## 查看文件状态

    git status
    
    git status -s 简洁输出
    
## 加入 暂存区

    git add 
    
    git reset head fimename // 变为未跟踪 （小心使用）
    
## 提交到 本地仓库

    git commit
    
    git commit -m "描述信息"
    
    在暂存区 的 文件 才可以 提交哦
    
    git commit 直接输入 是进入一个 写入日志的模式
    
    
## 删除文件

    git rm fimeName
    
    // 删除 注意 工作区
    // 暂存区
    // 本地仓库
    
## 添加文件到 忽略列表

    在工作目录中创建一个名称为
    .gitignore文件
    eg:
    *.txt
    !demo.txt // demo.txt 不忽略
    /targer  当前目录下targer目录
    test/       test目录下面
    test/*.txt test目录下 文件
    test/**/*.txt    test所有目录下
    
    
## 查看日志记录

    git log
    
    按q 退出
    
    
## 远程仓库

    git push 提交到 远程仓库
    
### 查看 远程仓库

    git remote
    
    git remote -v 详细信息
    
## 添加远程仓库

    git remote add origin url（远程地址） // 前提 你的远程要有这个地址 // origin 远程默认的名字
    // 就是 将你 远程个本地 关联起来
    
    git remote show origin 查看状态
    // 一个 本地 可以对应多个远程仓库    
    
## 从远程仓库抓取 拉去

    git fetch // 不会自动合并
    git pull // 自动合并
    
    抓取：
    git fetch origin master
    // 没有 自动合并到工作区
    // 在暂存区里面
    // 需要手动合并
    git merge origin/master
    // 就合并啦~
    
    拉取：
    git pull origin master
    // 如果仓库中存在文件 
    // 跟远程 签名不一致
    // 就会报错 无关历史
    解决：
    加上 --allow-unrelated-histories
    //
    git pull origin master --allow-unrelated-histories
    
## 推送到远程

    git push origin master
    
    //
    
    git commit -a -m "信息"
    // 相当于 git add + git commit
    
    
## git 分支 (本地/远程)

    git branch 查看本地分支
    git branch -r 远程分支
    git branch -a 所有
    
### 创建分支
    
    git branch 分支名字 // 创建本地分支
    
### 切换分支

    git checkout 分支名
    
            
### 推送分支到远程

    git push origin 分支名
    
### 合并分支

    git merge b1 // 合并 b1 分支 到 当前分支
    // 需要在当前 分支
    
    // 要是 合并的俩文件都修改过了 
    // 合并的时候 会报错
    // 提示 自动合并 错误 ，需要修复
    // 这个 时候已经 合并了
    // 只不过 多了写奇怪的东西
    // 手动 去除就OK
    // 然后 git add 就ok了
    
### 推送到分支

    git push origin 分支
    
    
### 删除分支

    git branch -d 分支名
    
    git branch -D 分支名 // 强制删除
    
    
    // 删除 远程地址 分支
    git push origin -d 分支名
    
    
## git 标签

    标记 发布的版本
    //
    某个特定时间点 的状态
    
    
### 查看创建 标签

    git tag // 查看标签
    
    git tag 标签名 //创建标签
    // git tag v1.0
    // git tag v2.0
    
    git show 标签名 // 查看标签名
    
    
    推送标签 
    //
    git push origin v1.0
    
### 检出标签

    创建新分支 并且指向 标签
    // 创建 新分支
    git checkout -b b1 v1.0
    
    // 新分支 状态 就是 v1.0 状态
    
### 删除标签
    
    git tag -d v0.1 // 删除 本地 的标签
    
    git push origin :refs/tags/v0.1 // 删除 远程 标签
    
                
    
    