<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>简单实用国产jQuery UI框架 - DWZ富客户端框架(J-UI.com)</title>

<link href="resources/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="resources/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="resources/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="resources/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="resources/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<!-- 覆盖dwz在css样式,项目自定义 -->
<link href="resources/dwz/themes/diy.css" rel="stylesheet" type="text/css" media="screen"/>

<script src="resources/dwz/js/speedup.js" type="text/javascript"></script>
<script src="resources/dwz/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="resources/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="resources/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="resources/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="resources/dwz/xheditor/xheditor-1.1.12-zh-cn.min.js" type="text/javascript"></script>
<script src="resources/dwz/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="resources/dwz/uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>
<script src="resources/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="resources/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("resources/dwz/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"resources/dwz/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换城市</a>
						<ul>
							<li><a href="sidebar_1.html">北京</a></li>
							<li><a href="sidebar_2.html">上海</a></li>
							<li><a href="sidebar_2.html">南京</a></li>
							<li><a href="sidebar_2.html">深圳</a></li>
							<li><a href="sidebar_2.html">广州</a></li>
							<li><a href="sidebar_2.html">天津</a></li>
							<li><a href="sidebar_2.html">杭州</a></li>
						</ul>
					</li>
					<li><a href="https://me.alipay.com/dwzteam" target="_blank">捐赠</a></li>
					<li><a href="changepwd.html" target="dialog" width="600">设置</a></li>
					<li><a href="http://www.cnblogs.com/dwzjs" target="_blank">博客</a></li>
					<li><a href="http://weibo.com/dwzui" target="_blank">微博</a></li>
					<li><a href="http://bbs.dwzjs.com" target="_blank">论坛</a></li>
					<li><a href="login.html">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>界面组件</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="tabsPage.html" target="navTab">主框架面板</a>
								<ul>
									<li><a href="users/index" target="navTab" rel="users-list">我的用户</a></li>
									<li><a href="http://www.baidu.com" target="navTab" rel="page1">页面一(外部页面)</a></li>
									<li><a href="demo_page2.html" target="navTab" rel="external" external="true">iframe navTab页面</a></li>
									<li><a href="demo_page1.html" target="navTab" rel="page1" fresh="false">替换页面一</a></li>
									<li><a href="demo_page2.html" target="navTab" rel="page2">页面二</a></li>
									<li><a href="demo_page4.html" target="navTab" rel="page3" title="页面三（自定义标签名）">页面三</a></li>
									<li><a href="demo_page4.html" target="navTab" rel="page4" fresh="false">测试页面（fresh="false"）</a></li>
									<li><a href="w_editor.html" target="navTab">表单提交会话超时</a></li>
									<li><a href="demo/common/ajaxTimeout.html" target="navTab">navTab会话超时</a></li>
									<li><a href="demo/common/ajaxTimeout.html" target="dialog">dialog会话超时</a></li>
									<li><a href="index_menu.html" target="_blank">横向导航条</a></li>
								</ul>
							</li>
							
							<li><a>常用组件</a>
								<ul>
									<li><a href="w_panel.html" target="navTab" rel="w_panel">面板</a></li>
									<li><a href="w_tabs.html" target="navTab" rel="w_tabs">选项卡面板</a></li>
									<li><a href="w_dialog.html" target="navTab" rel="w_dialog">弹出窗口</a></li>
									<li><a href="w_alert.html" target="navTab" rel="w_alert">提示窗口</a></li>
									<li><a href="w_list.html" target="navTab" rel="w_list">CSS表格容器</a></li>
									<li><a href="demo_page1.html" target="navTab" rel="w_table">表格容器</a></li>
									<li><a href="w_removeSelected.html" target="navTab" rel="w_table">表格数据库排序+批量删除</a></li>
									<li><a href="w_tree.html" target="navTab" rel="w_tree">树形菜单</a></li>
									<li><a href="w_accordion.html" target="navTab" rel="w_accordion">滑动菜单</a></li>
									<li><a href="w_editor.html" target="navTab" rel="w_editor">编辑器</a></li>
									<li><a href="w_datepicker.html" target="navTab" rel="w_datepicker">日期控件</a></li>
									<li><a href="demo/database/db_widget.html" target="navTab" rel="db">suggest+lookup+主从结构</a></li>
									<li><a href="demo/database/treeBringBack.html" target="navTab" rel="db">tree查找带回</a></li>
									<li><a href="demo/sortDrag/1.html" target="navTab" rel="sortDrag">单个sortDrag示例</a></li>
									<li><a href="demo/sortDrag/2.html" target="navTab" rel="sortDrag">多个sortDrag示例</a></li>
								</ul>
							</li>
									
							<li><a>表单组件</a>
								<ul>
									<li><a href="w_validation.html" target="navTab" rel="w_validation">表单验证</a></li>
									<li><a href="w_button.html" target="navTab" rel="w_button">按钮</a></li>
									<li><a href="w_textInput.html" target="navTab" rel="w_textInput">文本框/文本域</a></li>
									<li><a href="w_combox.html" target="navTab" rel="w_combox">下拉菜单</a></li>
									<li><a href="w_checkbox.html" target="navTab" rel="w_checkbox">多选框/单选框</a></li>
									<li><a href="demo_upload.html" target="navTab" rel="demo_upload">iframeCallback表单提交</a></li>
									<li><a href="w_uploadify.html" target="navTab" rel="w_uploadify">uploadify多文件上传</a></li>
								</ul>
							</li>
							<li><a>组合应用</a>
								<ul>
									<li><a href="demo/pagination/layout1.html" target="navTab" rel="pagination1">局部刷新分页1</a></li>
									<li><a href="demo/pagination/layout2.html" target="navTab" rel="pagination2">局部刷新分页2</a></li>
								</ul>
							</li>
							<li><a href="dwz.frag.xml" target="navTab" external="true">dwz.frag.xml</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>典型页面</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder treeCheck">
							<li><a href="demo_page1.html" target="navTab" rel="demo_page1">查询我的客户</a></li>
							<li><a href="demo_page1.html" target="navTab" rel="demo_page2">表单查询页面</a></li>
							<li><a href="demo_page4.html" target="navTab" rel="demo_page4">表单录入页面</a></li>
							<li><a href="demo_page5.html" target="navTab" rel="demo_page5">有文本输入的表单</a></li>
							<li><a href="javascript:;">有提示的表单输入页面</a>
								<ul>
									<li><a href="javascript:;">页面一</a></li>
									<li><a href="javascript:;">页面二</a></li>
								</ul>
							</li>
							<li><a href="javascript:;">选项卡和图形的页面</a>
								<ul>
									<li><a href="javascript:;">页面一</a></li>
									<li><a href="javascript:;">页面二</a></li>
								</ul>
							</li>
							<li><a href="javascript:;">选项卡和图形切换的页面</a></li>
							<li><a href="javascript:;">左右两个互动的页面</a></li>
							<li><a href="javascript:;">列表输入的页面</a></li>
							<li><a href="javascript:;">双层栏目列表的页面</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>流程演示</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">列表</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">列表</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<h2><a href="doc/dwz-user-guide.pdf" target="_blank">DWZ框架使用手册(PDF)</a></h2>
								<a href="doc/dwz-user-guide.swf" target="_blank">DWZ框架演示视频</a>
							</div>
							<div class="right">
								<p><a href="doc/dwz-user-guide.zip" target="_blank" style="line-height:19px">DWZ框架使用手册(CHM)</a></p>
								<p><a href="doc/dwz-ajax-develop.swf" target="_blank" style="line-height:19px">DWZ框架Ajax开发视频教材</a></p>
							</div>
							<p><span>DWZ富客户端框架</span></p>
							<p>DWZ官方微博:<a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a></p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
							
							<p style="color:red">DWZ官方微博 <a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a></p>
							<p style="color:red">DWZ官方微群 <a href="http://q.weibo.com/587328/invitation=11TGXSt-148c2" target="_blank">http://q.weibo.com/587328/invitation=11TGXSt-148c2</a></p>

<div class="divider"></div>
<h2>dwz v1.2视频教程:</h2>
<p><a href="http://www.u-training.com/thread-57-1-1.html" target="_blank">http://www.u-training.com/thread-57-1-1.html</a></p>

<div class="divider"></div>
<h2>DWZ系列开源项目:</h2>
<div class="unit"><a href="http://code.google.com/p/dwz/" target="_blank">dwz富客户端框架 - jUI</a></div>
<div class="unit"><a href="http://code.google.com/p/dwz4j" target="_blank">dwz4j(Java Web)快速开发框架 + jUI整合应用</a></div>
<div class="unit"><a href="http://code.google.com/p/j-hi" target="_blank">J-HI(Java Web)快速开发平台 + jUI整合应用（Eclipse插件生成项目代码）</a></div>
<div class="unit"><a href="http://code.google.com/p/dwz4php" target="_blank">ThinkPHP2.1 + jUI整合应用</a></div>
<div class="unit"><a href="http://www.yiiframework.com/extension/dwzinterface/" target="_blank">YII + jUI整合应用</a></div>

<div class="divider"></div>
<h2>常见问题及解决:</h2>
<pre style="margin:5px;line-height:1.4em">
Error loading XML document: dwz.frag.xml
直接用IE打开index.html弹出一个对话框：Error loading XML document: dwz.frag.xml
原因：没有加载成功dwz.frag.xml。IE ajax laod本地文件有限制, 是ie安全级别的问题, 不是框架的问题。
解决方法：用firefox打开或部署到apache下。
</pre>

<div class="divider"></div>
<h2>有偿服务请联系:</h2>
<pre style="margin:5px;line-height:1.4em;">
定制化开发，公司培训，技术支持
合作电话：010-52897073
邮箱：support@dwzjs.com
</pre>
						</div>
						
						<div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
							<iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<%@ include file="/common/footer_dwz.jsp" %>

</body>
</html>