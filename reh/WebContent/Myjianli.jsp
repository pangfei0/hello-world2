<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
label{
margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
}
.label {
	display: block;
	clear: left;
	float: left;
	width: 175px;
	text-align: right;
	padding: 7px 15px 0 0;
	text-transform: uppercase;	
	font-weight: bold;
}
</style>
</head>
<body>
<div id="content">
    <div id="yonghuxingxi">
          <div id="num11">
          <h3>个人信息</h3>
          </div>
          <div id="num12">
          <div> <label class="label" >姓名：</label>   <label class="label" >姓名：</label>   <input id="USER_NAME" name="USER_NAME" ></input></div>
           <div><label class="label"  >性别：</label>      <input id="USER_AGE" name="USER_AGE"  ></input></div>
          
           <label class="label">现居住地址：</label>     <input id="USER_ADDR_POS"  name="USER_ADDR_POS"></input>
           <label class="label">手机：</label>          <input id="USER_PHONE"  name="USER_PHONE"></input>
           <label class="label">邮箱：</label>           <input id="USER_EMAIL"  name="USER_EMAIL"></input>
           <label class="label" >姓名：</label>     <label id="USER_NAME" ></label>
           <label class="label">性别：</label>      <label id="USER_AGE" ></label>
          <!--  <label class="label">出生年月：</label>   <input name="" ></input>
           <label class="label">参加工作年份：</label>   <input name="workage" ></input> -->
           <label class="label">现居住地址：</label>     <label id="USER_ADDR_POS" ></label>
           <label class="label">手机：</label>          <label id="USER_PHONE" ></label>
           <label class="label">邮箱：</label>           <label id="USER_EMAIL" ></label>
          </div>
          <div id="num13" >
           <form  hidden="ture">
            <label class="label">姓名：</label>     <input id="USER_NAME" name="USER_NAME" ></input>
           <label class="label">性别：</label>      <input id="USER_AGE" name="USER_AGE"></input>
          <!--  <label class="label">出生年月：</label>   <input name="" ></input>
           <label class="label">参加工作年份：</label>   <input name="workage" ></input> -->
           <label class="label">现居住地址：</label>     <input id="USER_ADDR_POS"  name="USER_ADDR_POS"></input>
           <label class="label">手机：</label>          <input id="USER_PHONE"  name="USER_PHONE"></input>
           <label class="label">邮箱：</label>           <input id="USER_EMAIL"  name="USER_EMAIL"></input>
           </form>
          </div>
    </div>
    <div id="qiuzhiyixiang">
     <div id="num21">
          <h3>职业意向</h3>
          </div>
          <div id="num22">
          </div>
          <div id="num23">
          </div>
    </div>
    <div id="gongzuojinyan">
     <div id="num31">
           <h3>工作经验</h3>
          </div>
          <div id="num32">
          </div>
          <div id="num33">
          </div>
    </div>
    <div id="jiaoyubeijin">
     <div id="num41">
          <h3>教育背景</h3>
          </div>
          <div id="num42">
          </div>
          <div id="num43">
          </div>
    </div>
    <div id="muqianzhuangtai">
     <div id="num51">
          <h3>目前状态</h3>
          </div>
          <div id="num52">
          </div>
          <div id="num53">
          </div>
    </div>
    <div id="ziwopingjia">
     <div id="num61">
          <h3>自我评价</h3>
          </div>
          <div id="num62">
          </div>
          <div id="num63">
          </div>
    </div>
    <div id="xiangmujinyan">
     <div id="num71">
          <h3>项目经验</h3>
          </div>
          <div id="num72">
          </div>
          <div id="num73">
          </div>
    </div>
    <div id="peixunjinli">
     <div id="num81">
           <h3>培训经历</h3>
          </div>
          <div id="num82">
          </div>
          <div id="num83">
          </div>
    </div>
    <div id="qitanengli">
     <div id="num91">
          <h3>其他能力</h3>
          </div>
          <div id="num92">
          </div>
          <div id="num93">
          </div>
    </div>
    <div id="bucongxingxi">
     <div id="num01">
          <h3>补充信息</h3>
          </div>
          <div id="num02">
          </div>
          <div id="num03">
          </div>
    </div>
</div>
</body>
</html>