

# ts 学习笔记

    编辑环境 vscode
    
    
> 需要node.js

    全局安装ts
    
`npm install typescript-g`

**hello world**

```typescript
function helloTs(){
    let hello :string = "hello world";
    console.log(hello)
}

helloTs()
```

    执行
    tsc Demo1.ts 编译为js文件
    然后 node Demo1.js 执行
    
**安装ts-node**

    提高编译效率
    npm 安装
    
`npm install -g ts-node`

    可以直接使用 ts-node Demo1.ts 执行ts文件啦~
    
    
### ts 静态类型

    定义方法：
    const count :number = 1;

> 自定义静态类型

```typescript
interface coustomConstType {
  uName: string , 
  age: number 
}

const  cct: coustomConstType = {
    uName : 'qma',
    age : 18
}
```


#### 基础静态类型 和对象类型

    ts 中静态类型分为 基础静态类型和对象静态类型
    
> 基础静态类型

    const str:string = 'aaa';
    // string number undefinde symbol boolean void 


> 对象类型

    比如如上代码
    
```typescript
const cst:{
    name:string,
    age:number
} = {
    name:'大脚',
    age:18
}
console.log(cst.name)
```

    或者数组类型
    
`const arr: string[] = ['a' , 'b' , 'c' ]`

> 类

    class
    
    
```typescript

class Person{}

const dalao:Person = new Person()
```

> 函数类型

    const functionType : () => string =() => {return 'dalao'}
    
    
##### 对象类型

    对象类型
    数组类型
    类类型
    函数类型
    
### 类型注解 类型推断

    let count :number; // 类型注解
    count = 100;
    
    let count = 100; // 类型推断 
    
```typescript
function sum(v1:number , v2:number) {
  return v1 + v2;
}

const t = sum(1,2);
```

### 函数参数 返回值

```typescript
function sum(v1:number , v2:number) : number { // number 可以省略 可以自动推断
  return v1 + v2;
}

function voidFunc() : void {
  //TODO
}
// 或者
function voidFunc2() {
  //TODO
}

// never 返回值类型
// 意思是 一个函数永远也不会执行完

function neverTest(): never{
    // throw
    //while
    while (true){}
    //TODO
}

// 参数解构

function add({v1 , v2} : {v1:number , v2:number}){
    return v1 + v2
}

```

### 数组

    


    