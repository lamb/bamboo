<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="#">Bamboo</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				
				<form id="signForm" class="navbar-form pull-right" action="${contextPath}/signin" method="post">
	              <input class="span2" type="text" name="email" placeholder="Email" rel="popover" data-placement="bottom" />
	              <input class="span2" type="password" name="password" placeholder="Password" rel="popover" data-placement="bottom" />
	              <input type="submit" class="btn" value="登陆" />
	            </form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>