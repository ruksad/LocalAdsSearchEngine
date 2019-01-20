<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>:: Marketing ::</title>
<!-- Bootstrap Css -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom Css -->
<link href="css/custom.css" rel="stylesheet">
<!-- Font-awesome Css -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
<header class="hd-bg">
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <div class="logo">
          <p><a href="index.html">Logo</a></p>
        </div>
      </div>
      <div class="col-md-10">
        <div class="col-md-6"> 
          <!-- Button trigger modal -->
          <div class="btn-lg modal-btn" data-toggle="modal" data-target="#myModal1">
            <p><i class="fa fa-map-marker" aria-hidden="true"></i> Select A Region </p>
          </div>
          <!-- Modal1 -->
          <div class="modal fade" data-backdrop="static" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="arrow" data-dismiss="modal" aria-label="Arrow"><span aria-hidden="true"><i class="fa fa-angle-left"></i></span></button>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                  <h4 class="modal-title" id="myModalLabel">
                    <div class="col-md-6">
                      <div id="imaginary_container">
                        <div class="input-group stylish-input-group">
                          <input type="text" class="form-control"  placeholder="Type region or city" >
                        </div>
                      </div>
                    </div>
                  </h4>
                </div>
                <div class="modal-body">
                  <div class="row">
                    <div class="col-md-12">
                      <h4 class="modal-title" id="myModalLabel">Popular cities:</h4>
                    </div>
                  </div>
                  <div class="popular-cities">
                    <div class="list full">
                      <ul>
                        <li><a href="#" class="link"><span>Hyderabad</span></a></li>
                        <li><a href="#" class="link"><span>Bengaluru</span></a></li>
                        <li><a href="#" class="link"><span>Chennai</span></a></li>
                      </ul>
                      <ul>
                        <li><a href="#" class="link"><span>Chandigarh</span></a></li>
                        <li><a href="#" class="link"><span>Coimbatore</span></a></li>
                        <li><a href="#" class="link"><span>Delhi</span></a></li>
                      </ul>
                      <ul>
                        <li><a href="#" class="link"><span>Gurgaon</span></a></li>
                        <li><a href="#" class="link"><span>Ahmedabad</span></a></li>
                        <li><a href="#" class="link"><span>Jaipur</span></a></li>
                      </ul>
                      <ul>
                        <li><a href="#" class="link"><span>Kochi</span></a></li>
                        <li><a href="#" class="link"><span>Kolkata</span></a></li>
                        <li><a href="#" class="link"><span>Lucknow</span></a></li>
                      </ul>
                      <ul>
                        <li><a href="#" class="link"><span>Ludhiana</span></a></li>
                        <li><a href="#" class="link"><span>Mumbai</span></a></li>
                        <li><a href="#" class="link"><span>Nagpur</span></a></li>
                      </ul>
                      <ul>
                        <li><a href="#" class="link"><span>Pune</span></a></li>
                        <li><a href="#" class="link"><span>Surat</span></a></li>
                        <li><a href="#" class="link"><span>Thiruvananthapuram</span></a></li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="modal-footer">
                  <div id="all_cities"><a href="#">All Cities</a> </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Modal2 -->
          <div class="modal fade" data-backdrop="static" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="arrow" data-dismiss="modal" aria-label="Arrow"><span aria-hidden="true"><i class="fa fa-angle-left"></i></span></button>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                  <h4 class="modal-title" id="myModalLabel">
                    <div class="col-md-6">
                      <div id="imaginary_container">
                        <div class="input-group stylish-input-group">
                          <input type="text" class="form-control"  placeholder="Type region or city" >
                        </div>
                      </div>
                    </div>
                  </h4>
                </div>
                <div class="modal-body">
                  <div class="row">
                    <div class="col-md-12">
                      <h4 class="modal-title" id="myModalLabel">States</h4>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Andaman & Nicobar Islands</a></li>
                        <li><a href="#" class="pop_up_3">Andhra Pradesh</a></li>
                        <li><a href="#">Arunachal Pradesh</a></li>
                        <li><a href="#">Assam</a></li>
                        <li><a href="#">Bihar</a></li>
                        <li><a href="#">Chandigarh</a></li>
                        <li><a href="#">Chhattisgarh</a></li>
                        <li><a href="#">Dadra & Nagar Haveli</a></li>
                        <li><a href="#">Daman & Diu</a></li>
                      </ul>
                    </div>
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Delhi</a></li>
                        <li><a href="#">Goa</a></li>
                        <li><a href="#">Gujarat</a></li>
                        <li><a href="#">Haryana</a></li>
                        <li><a href="#">Himachal Pradesh</a></li>
                        <li><a href="#">Jammu & Kashmir</a></li>
                        <li><a href="#">Jharkhand</a></li>
                        <li><a href="#">Karnataka</a></li>
                        <li><a href="#">Kerala</a></li>
                        <li><a href="#">Lakshadweep</a></li>
                      </ul>
                    </div>
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Madhya Pradesh</a></li>
                        <li><a href="#">Maharashtra</a></li>
                        <li><a href="#">Manipur</a></li>
                        <li><a href="#">Meghalaya</a></li>
                        <li><a href="#">Mizoram</a></li>
                        <li><a href="#">Nagaland</a></li>
                        <li><a href="#">Odisha</a></li>
                        <li><a href="#">Pondicherry</a></li>
                        <li><a href="#">Punjab</a></li>
                        <li><a href="#">Rajasthan</a></li>
                      </ul>
                    </div>
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Sikkim</a></li>
                        <li><a href="#">Tamil Nadu</a></li>
                        <li><a href="#">Telangana</a></li>
                        <li><a href="#">Tripura</a></li>
                        <li><a href="#">Uttar Pradesh</a></li>
                        <li><a href="#">Uttaranchal</a></li>
                        <li><a href="#">West Bengal</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="modal fade" data-backdrop="static" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="arrow" data-dismiss="modal" aria-label="Arrow"><span aria-hidden="true"><i class="fa fa-angle-left"></i></span></button>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                  <h4 class="modal-title" id="myModalLabel">
                    <div class="col-md-6">
                      <div id="imaginary_container">
                        <div class="input-group stylish-input-group">
                          <input type="text" class="form-control"  placeholder="Type region or city" >
                        </div>
                      </div>
                    </div>
                  </h4>
                </div>
                <div class="modal-body">
                  <div class="row">
                    <div class="col-md-12">
                      <h4 class="modal-title" id="myModalLabel">Districts</h4>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Anantapur </a></li>
                        <li><a href="#">Chittoor </a></li>
                        <li><a href="#">East Godavari </a></li>
                        <li><a href="#">Guntur 	Guntur </a></li>
                      </ul>
                    </div>
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Krishna </a></li>
                        <li><a href="#">Kurnool</a></li>
                        <li><a href="#">Sri Potti Sri Ramulu Nellore </a></li>
                        <li><a href="#">Prakasam </a></li>
                      </ul>
                    </div>
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Srikakulam </a></li>
                        <li><a href="#">Visakhapatnam </a></li>
                        <li><a href="#">Vizianagaram </a></li>
                        <li><a href="#">West Godavari </a></li>
                        <li><a href="#">YSR Kadapa</a></li>
                      </ul>
                    </div>
                    <div class="col-md-3 city-list">
                      <ul>
                        <li><a href="#">Sri Potti Sri Ramulu Nellore </a></li>
                        <li><a href="#">Prakasam </a></li>
                        <li><a href="#">Srikakulam </a></li>
                        <li><a href="#">Visakhapatnam </a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="top-bar">
            <div class="header-top-inner">
              <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" id="menu1" type="button" data-toggle="dropdown"><i class="fa fa-user-circle"></i>&nbsp; My Account <span class="caret"></span></button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                  <li><a href="#">ADS</a></li>
                  <li><a href="#">MESSAGES</a></li>
                  <li><a href="#">ALERTS</a></li>
                </ul>
                <a href="post-free-ad.php" class="btn btn-default post" type="button"><i class="fa fa-bullhorn"></i>&nbsp; Post Free Ad</a> <a href="#" class="btn btn-default" role="button" data-toggle="modal" data-target="#login-modal"><i class="fa fa-lock"></i>&nbsp; Login (or) Register</a> </div>
              <!-- /.cnt-account --> 
            </div>
            <!-- /.header-top-inner --> 
          </div>
          <!-- /.top-bar--> 
        </div>
      </div>
      <!-- BEGIN # MODAL LOGIN -->
      <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header" align="center"> <img class="img-circle" id="img_logo" src="images/login-logo.png">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> </button>
            </div>
            <!-- Begin # DIV Form -->
            <div id="div-forms"> 
              <!-- Begin # Login Form -->
              <form id="login-form">
                <div class="modal-body">
                  <div id="div-login-msg">
                    <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                    <span id="text-login-msg">Type your username and password.</span> </div>
                  <input id="login_username" class="form-control" type="text" placeholder="Username (type ERROR for error effect)" required>
                  <input id="login_password" class="form-control" type="password" placeholder="Password" required>
                  <div class="checkbox">
                    <label>
                      <input type="checkbox">
                      Remember me </label>
                  </div>
                </div>
                <div class="modal-footer">
                  <div>
                    <p>By Submitting, I Agree T&amp;C</p>
                    <button type="submit" class="btn btn-primary btn-sm">Submit</button>
                  </div>
                  <div class="social_icon">
                    <ul>
                      <li class="face"><a href="#"><i class="fa fa-facebook-square"></i> &nbsp;Connect with Facebook</a></li>
                      <li class="goog"><a href="#"><i class="fa fa-google-plus-square"></i> &nbsp;Connect with Google Plus</a></li>
                    </ul>
                  </div>
                  <div>
                    <button id="login_lost_btn" type="button" class="btn btn-link">Lost Password?</button>
                    <button id="login_register_btn" type="button" class="btn btn-link">Register</button>
                  </div>
                </div>
              </form>
              <!-- End # Login Form --> 
              <!-- Begin | Lost Password Form -->
              <form id="lost-form" style="display:none;">
                <div class="modal-body">
                  <div id="div-lost-msg">
                    <div id="icon-lost-msg" class="glyphicon glyphicon-chevron-right"></div>
                    <span id="text-lost-msg">Type your e-mail.</span> </div>
                  <input id="lost_email" class="form-control" type="text" placeholder="E-Mail" required>
                </div>
                <div class="modal-footer">
                  <div>
                    <p>Password reset like us selected successfully</p>
                    <button type="submit" class="btn btn-primary btn-sm">Verify</button>
                  </div>
                  <div class="social_icon">
                    <ul>
                      <li class="face"><a href="#"><i class="fa fa-facebook-square"></i> &nbsp;Connect with Facebook</a></li>
                      <li class="goog"><a href="#"><i class="fa fa-google-plus-square"></i> &nbsp;Connect with Google Plus</a></li>
                    </ul>
                  </div>
                  <div>
                    <button id="lost_login_btn" type="button" class="btn btn-link">Log In</button>
                    <button id="lost_register_btn" type="button" class="btn btn-link">Register</button>
                  </div>
                </div>
              </form>
              <!-- End | Lost Password Form --> 
              <!-- Begin | Register Form -->
              <form id="register-form" style="display:none;">
                <div class="modal-body">
                  <div id="div-register-msg">
                    <div id="icon-register-msg" class="glyphicon glyphicon-chevron-right"></div>
                    <span id="text-register-msg">Register an account.</span> </div>
                  <input id="register_username" class="form-control" type="text" placeholder="Username" required>
                  <input id="register_email" class="form-control" type="text" placeholder="E-Mail" required>
                  <input id="register_password" class="form-control" type="password" placeholder="Password" required>
                  <input id="register_confirm_password" class="form-control" type="password" placeholder="Confirm Password" required>
                </div>
                <div class="modal-footer">
                  <div>
                    <p>By Submitting, I Agree</p>
                    <button type="submit" class="btn btn-primary btn-sm">Register</button>
                  </div>
                  <div class="social_icon">
                    <ul>
                      <li class="face"><a href="#"><i class="fa fa-facebook-square"></i> &nbsp;Connect with Facebook</a></li>
                      <li class="goog"><a href="#"><i class="fa fa-google-plus-square"></i> &nbsp;Connect with Google Plus</a></li>
                    </ul>
                  </div>
                  <div>
                    <button id="register_login_btn" type="button" class="btn btn-link">Log In</button>
                    <button id="register_lost_btn" type="button" class="btn btn-link">Lost Password?</button>
                  </div>
                </div>
              </form>
              <!-- End | Register Form --> 
            </div>
            <!-- End # DIV Form --> 
          </div>
        </div>
      </div>
      <!-- END # MODAL LOGIN --> 
    </div>
  </div>
  </div>
</header>

<!-- Forsale start================================================== -->
<section class="forsale">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="span12">
          <div class="tab-content">
            <div class="tab-pane" id="myaccount">My Account</div>
            <div class="tab-pane" id="ads">Ads</div>
            <div class="tab-pane" id="message">Message</div>
            <div class="tab-pane" id="smsalerts">SMS Alerts</div>
            <div class="tab-pane" id="subscription">Subscription</div>
          </div>
          <div id="tab" class="btn-group" data-toggle="buttons-radio"> <a href="#myaccount2" class="btn btn-large btn-info active" data-toggle="tab">My Account</a> <a href="#ads2" class="btn btn-large btn-info" data-toggle="tab">Ads</a> <a href="#message2" class="btn btn-large btn-info" data-toggle="tab">Message</a> <a href="#smsalerts2" class="btn btn-large btn-info"  data-toggle="tab">SMS Alerts</a> <a href="#subscription2" class="btn btn-large btn-info"  data-toggle="tab">Subscription</a> </div>
          <div class="tab-content">
            <div class="tab-pane active" id="myaccount2"> <br>
              <p class="lead">My Account</p>
              <div class="row">
                <div class="col-md-6">
                  <div class="profile">
                    <div class="profile_lft">
                      <p><a href="#"><img src="images/account_user.jpg"></a> </p>
                    </div>
                    <div class="profile_rgt">
                      <h1>Welcome to chiranjeevi</h1>
                      <p><a href="#"><i class="fa fa-address-card"></i> View my public profile</a></p>
                      <p>Register Staus: 3+ Years</p>
                      <p>Phone Verified: <span>Yes</span></p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="tab-pane" id="ads2"> <br>
              <p class="lead">Ads</p>
              <div class="row">
                <div class="span6"> 
                  <!-- Rightside content start here  -->
                  <div class="col-sm-12 col-md-12">
                    <div class="panel panel-default"> 
                      
                      <!-- vehicles_list start -->
                      <div class="vehicles_list"> 
                        <!-- vehiclesRow start -->
                        <div class="vehiclesRow"> <a href="#">
                          <div class="vehiclesImage"><img src="images/cars/car-1.jpg" alt=""></div>
                          <div class="vehiclesMain">
                            <div class="price"><strong><i class="fa fa-rupee"></i>5,10,000</strong></div>
                            <span class="textHeader">Maruthi Suzuki Swift Desire Blue 2015 used, </span> <span class="textLoc">Pune</span> <span class="textDesc"><img src="images/Verified-Icon.png" alt=""></span> <span class="textKms">95000 kms</span> <span class="textKms"> <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> <span><strong>Edit</strong></span> </span> <span class="textDate">Feb 17</span> </div>
                          </a> </div>
                        <!-- vehiclesRow end --> 
                        <!-- vehiclesRow start -->
                        <div class="vehiclesRow"> <a href="#">
                          <div class="vehiclesImage"><img src="images/cars/car-1.jpg" alt=""></div>
                          <div class="vehiclesMain">
                            <div class="price"><strong><i class="fa fa-rupee"></i>5,10,000</strong></div>
                            <span class="textHeader">Maruthi Suzuki Swift Desire Blue 2015 used,</span> <span class="textLoc">Pune</span> <span class="textDesc"><img src="images/Verified-Icon.png" alt=""></span> <span class="textKms">95000 kms</span> <span class="textKms"> <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> <span><strong>Edit</strong></span> </span> <span class="textDate">Feb 17</span> </div>
                          </a> </div>
                        <!-- vehiclesRow end --> 
                        
                        <!-- vehiclesRow start -->
                        <div class="vehiclesRow"> <a href="#">
                          <div class="vehiclesImage"><img src="images/furniture/beds.jpg" alt=""></div>
                          <div class="vehiclesMain">
                            <div class="price"><strong><i class="fa fa-rupee"></i>45,000</strong></div>
                            <span class="textHeader">Long lasting plywood of box Bed,</span> <span class="textLoc">Pune</span> <span class="textDesc"><img src="images/Verified-Icon.png" alt=""></span> <span class="textKms">450</span> <span class="textKms"> <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> <span><strong>Edit</strong></span> </span> <span class="textDate">Mar 15</span> </div>
                          </a> </div>
                        <!-- vehiclesRow end --> 
                        
                        <!-- vehiclesRow start -->
                        <div class="vehiclesRow"> <a href="#">
                          <div class="vehiclesImage"><img src="images/furniture/wardrobes.jpg" alt=""></div>
                          <div class="vehiclesMain">
                            <div class="price"><strong><i class="fa fa-rupee"></i>10,000</strong></div>
                            <span class="textHeader">Brown And White Wooden Wardrobe,</span> <span class="textLoc">Pune</span> <span class="textDesc"><img src="images/Verified-Icon.png" alt=""></span> <span class="textKms">500</span> <span class="textKms"> <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> <span><strong>Edit</strong></span> </span> <span class="textDate">Mar 15</span> </div>
                          </a> </div>
                        <!-- vehiclesRow end --> 
                        
                      </div>
                      <!-- vehicles_list end --> 
                    </div>
                  </div>
                  <!-- Rightside content end --> 
                </div>
              </div>
            </div>
            <div class="tab-pane" id="message2"> <br>
              <p class="lead">Message</p>
              <div class="row">
                <div class="col-md-6">
                  <div class="chat_nav">
                    <ul class="chat_nav_ul">
                      <li class="chat_nav_li-selected"><a href="#"><i class="fa fa-envelope"></i></a></li>
                      <li><a href="#"><i class="fa fa-folder-open"></i></a></li>
                      <li><a href="#"><i class="fa fa-trash"></i></a></li>
                      <li><a href="#"><i class="fa fa-image"></i></a></li>
                    </ul>
                    <div class="portlet-body chat-widget jane">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="media"> <a class="pull-left" href="#"> <img class="media-object img-circle" src="https://lorempixel.com/30/30/people/1/" alt=""> </a>
                            <div class="media-body">
                              <h4 class="media-heading">Jane Smith <span class="small pull-right">12:23 PM</span> </h4>
                              <p>Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?</p>
                            </div>
                          </div>
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-md-12">
                          <div class="media"> <a class="pull-left" href="#"> <img class="media-object img-circle" src="https://lorempixel.com/30/30/people/7/" alt=""> </a>
                            <div class="media-body">
                              <h4 class="media-heading">John Smith <span class="small pull-right">12:28 PM</span> </h4>
                              <p>Yeah I did. Everything looks good.</p>
                              <p>Did you have an update on purchase order #302?</p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="portlet portlet-default">
                    <div class="portlet-heading">
                      <div class="portlet-title">
                        <h4><i class="fa fa-circle text-green"></i> Jane Smith</h4>
                      </div>
                      <div class="portlet-widgets">
                        <div class="btn-group">
                          <button type="button" class="btn btn-white dropdown-toggle btn-xs" data-toggle="dropdown"> <i class="fa fa-circle text-green"></i> Status <span class="caret"></span> </button>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="fa fa-circle text-green"></i> Online</a> </li>
                            <li><a href="#"><i class="fa fa-circle text-orange"></i> Away</a> </li>
                            <li><a href="#"><i class="fa fa-circle text-red"></i> Offline</a> </li>
                          </ul>
                        </div>
                        <span class="divider"></span> <a data-toggle="collapse" data-parent="#accordion" href="#chat"><i class="fa fa-chevron-down"></i></a> </div>
                      <div class="clearfix"></div>
                    </div>
                    <div id="chat" class="panel-collapse collapse in">
                      <div>
                        <div class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height: 300px;">
                          <div class="row">
                            <div class="col-lg-12">
                              <p class="text-center text-muted small">January 1, 2014 at 12:23 PM</p>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col-lg-12">
                              <div class="media"> <a class="pull-left" href="#"> <img class="media-object img-circle" src="https://lorempixel.com/30/30/people/1/" alt=""> </a>
                                <div class="media-body">
                                  <h4 class="media-heading">Jane Smith <span class="small pull-right">12:23 PM</span> </h4>
                                  <p>Hi, I wanted to make sure you got the latest product report. Did Roddy get it to you?</p>
                                </div>
                              </div>
                            </div>
                          </div>
                          <hr>
                          <div class="row">
                            <div class="col-lg-12">
                              <div class="media"> <a class="pull-left" href="#"> <img class="media-object img-circle" src="https://lorempixel.com/30/30/people/7/" alt=""> </a>
                                <div class="media-body">
                                  <h4 class="media-heading">John Smith <span class="small pull-right">12:28 PM</span> </h4>
                                  <p>Yeah I did. Everything looks good.</p>
                                  <p>Did you have an update on purchase order #302?</p>
                                </div>
                              </div>
                            </div>
                          </div>
                          <hr>
                          <div class="row">
                            <div class="col-lg-12">
                              <div class="media"> <a class="pull-left" href="#"> <img class="media-object img-circle" src="https://lorempixel.com/30/30/people/7/" alt=""> </a>
                                <div class="media-body">
                                  <h4 class="media-heading">Jane Smith <span class="small pull-right">12:39 PM</span> </h4>
                                  <p>No not yet, the transaction hasn't cleared yet. I will let you know as soon as everything goes through. Any idea where you want to get lunch today?</p>
                                </div>
                              </div>
                            </div>
                          </div>
                          <hr>
                        </div>
                      </div>
                      <div class="portlet-footer">
                        <form role="form">
                          <div class="form-group">
                            <textarea class="form-control" placeholder="Enter message..."></textarea>
                          </div>
                          <div class="form-group">
                            <button type="button" class="btn btn-default pull-right">Send</button>
                            <div class="clearfix"></div>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="tab-pane" id="smsalerts2"> <br>
              <p class="lead">SMS Alerts</p>
              <div class="alert alert-success"> <strong>Success!</strong> Indicates a successful or positive action. </div>
              <div class="alert alert-info"> <strong>Info!</strong> Indicates a neutral informative change or action. </div>
              <div class="alert alert-warning"> <strong>Warning!</strong> Indicates a warning that might need attention. </div>
              <div class="alert alert-danger"> <strong>Danger!</strong> Indicates a dangerous or potentially negative action. </div>
            </div>
            <div class="tab-pane" id="subscription2"> <br>
              <p class="lead">Subscription</p>
              <div class="row">
                <div class="col-md-12">
                  <div class="samp">
                    <div class="col-md-4">
                      <label class="lable_title pull-right" for="Email">EMAIL<span class="cc914">*</span>:</label>
                    </div>
                    <div class="col-md-8">
                      <div class="ad_rgt">
                        <input class="form-control clr" id="inputTestID" name="inputTest" data-original-title="" title="" type="text">
                      </div>
                    </div>
                  </div>
                  <div class="samp">
                    <div class="col-md-4">
                      <label class="lable_title pull-right" for="Phone">PHONE<span class="cc914">*</span>:</label>
                    </div>
                    <div class="col-md-8">
                      <div class="ad_rgt">
                        <input class="form-control clr" id="inputTestID" name="inputTest" data-original-title="" title="" type="text">
                      </div>
                    </div>
                  </div>
                  <div class="samp">
                    <div class="col-md-4"> </div>
                    <div class="col-md-8">
                      <div class="ad_rgt">
                        <button type="button" class="btn btn-primary">Submit</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Forsale end================================================== --> 
<!-- footer start================================================== -->
<footer>
  <div class="primary-footer">
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-md-3">
          <div class="footer-widget usefull-link">
            <h3>Useful Links</h3>
            <ul>
              <li><a href="#">Popular Search</a></li>
              <li><a href="#">Locations, we are in</a></li>
              <li><a href="#">Contact us</a></li>
            </ul>
          </div>
        </div>
        <div class="col-sm-6 col-md-3">
          <div class="footer-widget usefull-link">
            <h3>Useful Links</h3>
            <ul>
              <li><a href="#">About us</a></li>
              <li><a href="#">Terms &amp; Conditions</a></li>
              <li><a href="#">Help &amp; Support</a></li>
            </ul>
          </div>
        </div>
        <div class="col-sm-6 col-md-3">
          <div class="footer-widget usefull-link">
            <h3>Follow us</h3>
            <ul class="social-network social-circle">
              <li><a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li>
              <li><a href="#" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
              <li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
              <li><a href="#" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
              <li><a href="#" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="copyright-wrapper text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p>Copyright &copy; 2018 Logo. All Rights Reserved.</p>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- footer end================================================== --> 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery.min.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.min.js"></script> 
<!-- login --> 
<script src="js/login.js"></script>
</body>
</html>