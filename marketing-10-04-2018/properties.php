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
<!-- bnr================================================== -->
<section class="bnr_inn">
  <form class="col-sm-12" id="searchForm_inn">
    <div class="form-group col-sm-10 col-sm-offset-1">
      <div class="form-group" style="display:inline;">
        <div class="input-group">
          <div class="input-group-btn">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Categories <span class="glyphicon glyphicon-chevron-down"></span></button>
            <ul class="dropdown-menu">
              <li><a href="#"><i class="fa fa-th-large" aria-hidden="true"></i>&nbsp; All Categories</a></li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-bed" aria-hidden="true"></i>&nbsp; Furniture</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-home" aria-hidden="true"></i>&nbsp; Properties</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-car" aria-hidden="true"></i>&nbsp; Vehicles</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-desktop" aria-hidden="true"></i>&nbsp; Electronics</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-paw"></i>&nbsp; Pets</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-child" aria-hidden="true"></i>&nbsp; Kids</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-address-book-o" aria-hidden="true"></i>&nbsp; Services</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-briefcase" aria-hidden="true"></i>&nbsp; Jobs</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><i class="fa fa-book" aria-hidden="true"></i>&nbsp; Books</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
              <li class="dropdown-submenu"> <a tabindex="-1" href="#"><img src="images/fashion-icon.png" alt="">&nbsp; Fashion & Beauty</a>
                <ul class="dropdown-menu">
                  <li><a tabindex="-1" href="#">Second level</a></li>
                  <li class="dropdown-submenu"> <a href="#">Even More..</a>
                    <ul class="dropdown-menu">
                      <li><a href="#">3rd level</a></li>
                      <li><a href="#">3rd level</a></li>
                    </ul>
                  </li>
                  <li><a href="#">Second level</a></li>
                  <li><a href="#">Second level</a></li>
                </ul>
              </li>
            </ul>
          </div>
          <input class="form-control" placeholder="What are searching for?" type="text">
          <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span> </span> </div>
      </div>
    </div>
  </form>
</section>
<!-- bnr end================================================== --> 

<!-- Forsale start================================================== -->
<section class="forsale">
  <div class="container-fluid">
    <div class="row"> 
      
      <!-- quality start -->
      <div class="col-md-12">
        <div class="quality">
          <div class="col-md-2">
            <form>
              <div class="form-group">
                <label for="price" class="price_max">Price :</label>
                <select class="form-control sort">
                  <option>Min</option>
                  <option>1000</option>
                  <option>2000</option>
                  <option>3000</option>
                  <option>4000</option>
                  <option>5000</option>
                </select>
              </div>
            </form>
          </div>
          <div class="col-md-2">
            <form>
              <div class="form-group">
                <label for="price">&nbsp;</label>
                <select class="form-control sort">
                  <option>Max</option>
                  <option>1000</option>
                  <option>2000</option>
                  <option>3000</option>
                  <option>4000</option>
                  <option>5000</option>
                </select>
              </div>
            </form>
          </div>
          <div class="col-md-2">
            <form>
              <div class="form-group">
                <label for="price" class="price_max">Bedrooms :</label>
                <select class="form-control sort">
                  <option>Beds </option>
                  <option>Bedroom</option>
                  <option>Conservatory</option>
                  <option>Corridor & hallway</option>
                  <option>Dining room</option>
                  <option>Doors</option>
                  <option>Dressing room</option>
                  <option>Floors</option>
                  <option>Garage/shed</option>
                  <option>Garden</option>
                </select>
              </div>
            </form>
          </div>
          <div class="col-md-2">
            <form>
              <div class="form-group">
                <label for="price" class="price_max">Area :</label>
                <select class="form-control sort">
                  <option>Min</option>
                  <option>1000</option>
                  <option>2000</option>
                  <option>3000</option>
                  <option>4000</option>
                  <option>5000</option>
                </select>
              </div>
            </form>
          </div>
          <div class="col-md-2">
            <form>
              <div class="form-group">
                <label for="price">&nbsp;</label>
                <select class="form-control sort">
                  <option>Max</option>
                  <option>1000</option>
                  <option>2000</option>
                  <option>3000</option>
                  <option>4000</option>
                  <option>5000</option>
                </select>
              </div>
            </form>
          </div>
          <div class="col-md-2">
            <form>
              <div class="form-group">
                <label for="price" class="price_max">Posted by :</label>
                <select class="form-control sort">
                  <option>Min</option>
                  <option>1000</option>
                  <option>2000</option>
                  <option>3000</option>
                  <option>4000</option>
                  <option>5000</option>
                </select>
              </div>
            </form>
          </div>
          <div class="col-md-2">
            <select class="sort">
              <option value="">Locality</option>
              <option value="">All</option>
              <option value="">Owner</option>
              <option value="">Dealer</option>
              <option value="">Builder</option>
            </select>
          </div>
          <div class="col-md-7">
            <select id="multiple-checkboxes" multiple="multiple" class="list_view">
              <option value="Model">Model</option>
              <option value="Corolla">Corolla</option>
              <option value="Corolla Altis">Corolla Altis</option>
              <option value="Etios">Etios</option>
              <option value="Etios Liva">Etios Liva</option>
              <option value="Fortuner">Fortuner</option>
              <option value="Innova">Innova</option>
              <option value="Land Cruiser">Land Cruiser</option>
              <option value="Land Cruiser Prado">Land Cruiser Prado</option>
              <option value="Prius">Prius</option>
              <option value="Qualis">Qualis</option>
              <option value="Others">Others</option>
            </select>
            <a href="list-view.php" class="list_view"><i class="fa fa-server"></i> List view</a> <a href="gallery-view.php" class="list_view active"> <i class="fa fa-th"></i> Gallery view</a> </div>
          <div class="col-md-3">
            <select class="sort">
              <option value="">Sort by posted date</option>
              <option value="">Sort by default</option>
              <option value="">Sort by posted date</option>
              <option value="">Sort by distance</option>
              <option value="">Sort by price: low &gt; high</option>
              <option value="">Sort by price: high &gt; low</option>
            </select>
          </div>
        </div>
      </div>
      <!-- quality end --> 
      <!-- side bar menu start here-->
      <div class="col-sm-2 col-md-2">
        <div class="panel-group" id="accordion">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"> Properties </a> </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
              <ul class="list-group">
                <li class="list-group-item"><a href="#">For Sale</a>
                  <ul class="list-group">
                    <li class="list-group-item"><a href="#">Flats</a></li>
                    <li class="list-group-item"><a href="#">Houses</a></li>
                    <li class="list-group-item"><a href="#">Lands</a></li>
                    <li class="list-group-item"><a href="#">Shops</a></li>
                    <li class="list-group-item"><a href="#">Offices</a></li>
                  </ul>
                </li>
              </ul>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
              <ul class="list-group">
                <li class="list-group-item"><a href="#">For Rent</a>
                  <ul class="list-group">
                    <li class="list-group-item"><a href="#">Flats</a></li>
                    <li class="list-group-item"><a href="#">Houses</a></li>
                    <li class="list-group-item"><a href="#">Rooments/PG</a></li>
                    <li class="list-group-item"><a href="#">Lands</a></li>
                    <li class="list-group-item"><a href="#">Shops</a></li>
                    <li class="list-group-item"><a href="#">Offices</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <!-- side bar menu end--> 
      <!-- Rightside content start here  -->
      <div class="col-sm-10 col-md-10">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title"><a href="#">Ads by Google</a></h3>
          </div>
          <!-- vehicles_list start -->
          <div class="vehicles_list"> 
            <!-- vehiclesRow start -->
            <div class="vehiclesRow"> <a href="#">
              <div class="vehiclesImage"><img src="images/furniture/houses.jpg" alt=""></div>
              <div class="vehiclesMain">
                <div class="price"><strong><i class="fa fa-rupee"></i>50,45,000</strong></div>
                <span class="textHeader">1BHK, 26Sqft, River touch flat for sale </span> <span class="textLoc">Pune shivaji nagar</span> <span class="textDesc"><img src="images/Verified-Icon.png" alt=""></span> <span class="textKms">For Sale, Falts </span> <span class="textDate">Mar 15</span> </div>
              </a> </div>
            <!-- vehiclesRow end --> 
            <!-- vehiclesRow start -->
            <div class="vehiclesRow"> <a href="#">
              <div class="vehiclesImage"><img src="images/furniture/land.jpg" alt=""></div>
              <div class="vehiclesMain">
                <div class="price"><strong><i class="fa fa-rupee"></i>10,00,000</strong></div>
                <span class="textHeader">500Sqft, Ourtring road touch flat for sale</span> <span class="textLoc">Pune</span> <span class="textDesc"><img src="images/Verified-Icon.png" alt=""></span> <span class="textKms">For Sale, Lands</span> <span class="textDate">Mar 15</span> </div>
              </a> </div>
            <!-- vehiclesRow end --> 
            
            <!-- Gallery-view start -->
            <div class="row">
              <div class="col-md-3">
                <div data-toggle="modal" data-target="#vehicle_one" class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/land_forsale.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,50,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">Rent office space in for best deals, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
              <div class="col-md-3">
                <div class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/flat.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,00,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">1000Sqft, Ourtring road touch flat for sale, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
              <div class="col-md-3">
                <div class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/flat.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,00,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">1000Sqft, Ourtring road touch flat for sale, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
              <div class="col-md-3">
                <div class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/flat.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,00,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">1000Sqft, Ourtring road touch flat for sale, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <div class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/flat.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,00,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">1000Sqft, Ourtring road touch flat for sale, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
              <div class="col-md-3">
                <div class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/flat.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,00,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">1000Sqft, Ourtring road touch flat for sale, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
              <div class="col-md-3">
                <div class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/flat.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,00,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">1000Sqft, Ourtring road touch flat for sale, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
              <div class="col-md-3">
                <div class="vehiclesGallery"> <a href="#">
                  <div class="vehiclesImage">
                    <p><img src="images/furniture/flat.jpg" alt=""></p>
                    <div class="add_info"> <i class="fa fa-rupee"></i>50,00,000 </div>
                  </div>
                  <div class="vehiclesMain">
                    <div class="textHeader ">1000Sqft, Ourtring road touch flat for sale, <span class="textLoc">Pune</span></div>
                  </div>
                  </a> </div>
              </div>
            </div>
            <!-- Gallery-view end --> 
          </div>
          <!-- vehicles_list end --> 
        </div>
      </div>
      <!-- Rightside content end --> 
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
<!-- modal --> 
<!--<script src="js/modal.js"></script>--> 
<!-- login --> 
<script src="js/login.js"></script> 
<!-- jquery --> 
<!--<script src="js/jquery.js"></script> --> 

<!-- bootstrap-multiselect --> 
<script src="js/bootstrap-multiselect.js"></script> 
<script type="text/javascript">
        $(document).ready(function() {
            $('#multiple-checkboxes').multiselect();
        });
    </script> 

<!-- Select a region start  --> 
<script type="text/javascript">
        $(function() {
           // $('.modal-btn').trigger('click');
            $('#all_cities').click(function() {
                $('#myModal1').modal('hide');
                $('#myModal2').modal('show');
            });
            $('.pop_up_3').click(function() {
                $('#myModal2').modal('hide');
                $('#myModal3').modal('show');
            });
        });
    </script> 
<!-- Select a region end  --> 

<!-- phone pop_up script start here --> 
<script>
    
	$(document).ready(function() {
        var divs = $('.mydivs>div');
        var now = 0; // currently shown div
        divs.hide().first().show();
        $("button[name=next]").click(function(e) {
            divs.eq(now).hide();
            now = (now + 1 < divs.length) ? now + 1 : 0;
            divs.eq(now).show(); // show next
        });
        $("button[name=prev]").click(function(e) {
            divs.eq(now).hide();
            now = (now > 0) ? now - 1 : divs.length - 1;
            divs.eq(now).show(); // or .css('display','block');
            //console.log(divs.length, now);
        });
    });
    
    </script> 

<!-- phone pop_up script end here --> 

<script>    
    
    // Stop carousel
$('.carousel').carousel({
  interval: false
});
 </script> 

<!-- vehicle_one pop_up start here -->
<div id="vehicle_one" class="modal fade" role="dialog">
<!-- modal-dialog start-->
<div class="modal-dialog wd80"> 
  <!-- Modal content-->
  <div class="modal-content mct"> 
    <!-- modal-header start-->
    <div class="modal-header">
      <button type="button" class="close cls_n" data-dismiss="modal">&times;</button>
      <div class="car_icon">
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#"><i class="fa fa-angle-right"></i>&nbsp; For Rent</a></li>
          <li><a href="#"><i class="fa fa-angle-right"></i>&nbsp; Office</a></li>
        </ul>
      </div>
    </div>
    <!-- modal-header end--> 
    <!-- modal-body start-->
    <div class="modal-body">
      <h4 class="modal-title vap_headline">
        <div class="col-md-8"><span class="pull-left">Rent office space in for best deals <b style="font-size:25px;"><i class="fa fa-rupee"></i>50,000</b></span></div>
        <div class="col-md-4"> <span class="pull-right">Advertiser</span></div>
      </h4>
      <!-- car_detail start-->
      <div class="car_detail">
        <div class="col-md-8"> 
          <!-- car_detail_lft start-->
          <div class="car_detail_lft">
            <div class="pull-left">Ad ID: 123456789 </div>
            <div class="pull-right"><i class="fa fa-rupee"></i> <strong>50,000</strong> </div>
            <div class="vap_images">
              <div class="big_container"> 
                
                <!-- slider start here -->
                <div class="carousel slide article-slide" id="article-photo-carousel"> 
                  
                  <!-- Wrapper for slides -->
                  <div class="carousel-inner cont-slider">
                    <div class="item active"> <img alt="" title="" src="images/furniture/office_big1.jpg"> </div>
                    <div class="item"> <img alt="" title="" src="images/furniture/office_big1.jpg"> </div>
                    <div class="item"> <img alt="" title="" src="images/furniture/office_big1.jpg"> </div>
                    <div class="item"> <img alt="" title="" src="images/furniture/office_big1.jpg"> </div>
                  </div>
                  <!-- Indicators -->
                  <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#article-photo-carousel"> <img alt="" src="images/furniture/office_sm1.jpg"> </li>
                    <li class="" data-slide-to="1" data-target="#article-photo-carousel"> <img alt="" src="images/furniture/office_sm1.jpg"> </li>
                    <li class="" data-slide-to="2" data-target="#article-photo-carousel"> <img alt="" src="images/furniture/office_sm1.jpg"> </li>
                    <li class="" data-slide-to="3" data-target="#article-photo-carousel"> <img alt="" src="images/furniture/office_sm1.jpg"> </li>
                  </ol>
                </div>
                <!-- slider end here --> 
                
              </div>
            </div>
            <div class="table_detail">
              <div class="user_content">
                <table width="100%" cellspacing="0" cellpadding="0">
                  <tbody>
                    <tr>
                      <td style="position:relative"><div id="vad">
                          <div>Description</div>
                          <div class="verna">
                            <p>Customize/Color Option Available<br/>
                              EMI Option Also Available<br/>
                              Cards Accepted<br/>
                              Complete Home furniture package also available </p>
                          </div>
                          
                          <!--For the title of features or attributes-->
                          <div>Additional Details</div>
                          <div id="cdt">
                            <div>
                              <div> Price per squre yd&sup2; </div>
                              <div>5,750</div>
                            </div>
                            <div>
                              <div> Square yards </div>
                              <div>400 yd&sup2;</div>
                            </div>
                            <div>
                              <div> Facing </div>
                              <div>East</div>
                            </div>
                          </div>
                        </div></td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <!-- car_detail_lft end--> 
        </div>
        <div class="col-md-4 br_l">
          <div class="col-md-12 nopad">
            <div class="motor">
              <div class="col-md-1 pds"> <i class="fa fa-user-circle"></i> </div>
              <div class="col-md-11"> Unity Motors<br/>
                <span class="online">Online</span> </div>
            </div>
            <div class="motor">
              <div class="col-md-1 pds"> <i class="fa fa-user-circle"></i> </div>
              <div class="col-md-11"> Since<br/>
                <span>2+ Years</span> </div>
            </div>
            <!-- <img src="images/ad.png" alt=""> --> </div>
          <div class="col-md-12 nopad br_b">
            <div class="col-md-12 text-center"><a href="#" class="btn-link-white view_number" type="button" data-toggle="modal" data-target="#phoneModal"><i class="fa fa-phone" aria-hidden="true"></i>&nbsp; View Number</a></div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="col-md-12" data-toggle="collapse" data-target="#cnt">
                <h3>Contact Details</h3>
              </div>
            </div>
            <div class="col-md-12 collapse" id="cnt">
              <div class="col-md-12">
                <div class="form-group">
                  <label for="comment">Comment:</label>
                  <textarea class="form-control" rows="5" id="comment"></textarea>
                </div>
              </div>
              <div class="col-md-12">
                <div class="form-group">
                  <label for="email">Email:</label>
                  <input type="text" class="form-control" id="email">
                </div>
              </div>
              <div class="col-md-12">
                <button type="button" class="btn btn-primary">Submit</button>
              </div>
            </div>
          </div>
          <div class="col-md-12 nopad br_b">
            <h3>Safety Tips</h3>
            <p>1. Lorem Ipsum is simply dummy </p>
            <p>2. Lorem Ipsum is simply dummy </p>
            <p>3. Lorem Ipsum is simply dummy </p>
          </div>
        </div>
        <!-- car_detail end--> 
      </div>
      <!-- modal-body end-->
      <div class="modal-footer"></div>
    </div>
    <!-- Modal content end--> 
  </div>
  <!-- modal-dialog end--> 
</div>
<!-- vehicle_one pop_up end --> 

<!-- Phone Modal start here -->
<div class="phoneModal-popup">
  <div class="modal fade" id="phoneModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-body">
          <div class="modal-header bgr">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title text-center phone_head" id="mySmallModalLabel">Please verify yourself via OTP</h4>
          </div>
          <div class="store-find-block">
            <div class="mydivs">
              <div class="store-find">
                <div class="store-head">
                  <h5>We'll send an OTP on your phone for verification</h5>
                </div>
                <!-- Text input-->
                <div class="store-form">
                  <form>
                    <div class="row">
                      <div class="form-group">
                        <label class="col-md-12 control-label sr-only" for="Phone">Phone</label>
                        <div class="col-md-12">
                          <input id="Phone" name="Phone" type="text" placeholder="Your Mobile No" class="form-control input-md dlr" required="">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="col-md-12 control-label sr-only" for="Phone">Email</label>
                        <div class="col-md-12">
                          <input id="Email" name="Email" type="text" placeholder="Your Email (optional)" class="form-control input-md dlr" required="">
                        </div>
                      </div>
                      
                      <!-- Button -->
                      <div class="form-group">
                        <div class="col-md-12">
                          <button id="generate_otp" name="next" class="btn btn-primary btn-block btn-sm dlr">Generate OTP</button>
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            <!-- next div code --> 
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Phone Modal end here -->

</body>
</html>