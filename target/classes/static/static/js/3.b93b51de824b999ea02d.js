webpackJsonp([3],{KOwW:function(s,e){},mvHQ:function(s,e,t){s.exports={default:t("qkKv"),__esModule:!0}},qkKv:function(s,e,t){var a=t("FeBl"),r=a.JSON||(a.JSON={stringify:JSON.stringify});s.exports=function(s){return r.stringify.apply(r,arguments)}},xJsL:function(s,e,t){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=t("mvHQ"),r=t.n(a),n=t("NHnr"),o={data:function(){return{type:1,username:"",password:"",user:{username2:"",password2:""}}},methods:{login:function(){var s=this;Object(n.postRequest)("api/public/login",{username:this.username,password:this.password}).then(function(e){200===e.data.code?(s.$message({message:""+e.data.msg,type:"success"}),"管理员"===e.data.data.role?(window.localStorage.setItem("user",r()(e.data.data)),s.$router.push("/my")):(window.localStorage.setItem("user",r()(e.data.data)),s.$router.push("/home"))):-1===e.data.code&&alert(e.data.msg)}).catch(function(s){console.log(s)})},regist:function(){var s=this;if(""!==this.user.username2&&""!==this.user.password2){var e={user_id:0,name:this.user.username2,password:this.user.password2,role:"普通用户",borrow_num:0};console.log(e),Object(n.postRequest)("/api/public/regist",e).then(function(e){200===e.data.code?(s.$message({message:""+e.data.msg,type:"success"}),s.type=1):-1===e.data.code&&alert(e.data.msg)}).catch(function(e){console.log(e),s.type=1})}else alert("关键信息不能为空")}}},i={render:function(){var s=this,e=s.$createElement,t=s._self._c||e;return t("div",{staticClass:"all"},[1===s.type?t("el-card",{staticClass:"box-card"},[t("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[t("span",[s._v("登录界面")])]),s._v(" "),t("div",{staticClass:"text item"},[t("el-input",{staticClass:"in",attrs:{"prefix-icon":"el-icon-user-solid",name:"username",placeholder:"请输入用户名"},model:{value:s.username,callback:function(e){s.username=e},expression:"username"}}),s._v(" "),t("el-input",{staticClass:"in",attrs:{"prefix-icon":"el-icon-lock",placeholder:"请输入密码",name:"password","show-password":""},model:{value:s.password,callback:function(e){s.password=e},expression:"password"}}),s._v(" "),t("el-button",{staticClass:"bt",attrs:{type:"primary",plain:""},on:{click:s.login}},[s._v("登录")]),s._v(" "),t("el-button",{staticClass:"bt",attrs:{type:"primary",plain:""},on:{click:function(e){s.type=2}}},[s._v("注册")])],1)]):s._e(),s._v(" "),2===s.type?t("el-card",{staticClass:"box-card"},[t("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[t("span",[s._v("欢迎注册我馆账号")])]),s._v(" "),t("div",{staticClass:"text item"},[t("el-input",{staticClass:"in",attrs:{"prefix-icon":"el-icon-user-solid",name:"username",placeholder:"请输入用户名"},model:{value:s.user.username2,callback:function(e){s.$set(s.user,"username2",e)},expression:"user.username2"}}),s._v(" "),t("el-input",{staticClass:"in",attrs:{"prefix-icon":"el-icon-lock",placeholder:"请输入密码",name:"password","show-password":""},model:{value:s.user.password2,callback:function(e){s.$set(s.user,"password2",e)},expression:"user.password2"}}),s._v(" "),t("el-button",{staticClass:"bt",attrs:{type:"primary",plain:""},on:{click:s.regist}},[s._v("注册")]),s._v(" "),t("el-button",{staticClass:"bt",attrs:{type:"primary",plain:""},on:{click:function(e){s.type=1}}},[s._v("返回")])],1)]):s._e()],1)},staticRenderFns:[]};var l=t("VU/8")(o,i,!1,function(s){t("KOwW")},"data-v-539abab6",null);e.default=l.exports}});
//# sourceMappingURL=3.b93b51de824b999ea02d.js.map