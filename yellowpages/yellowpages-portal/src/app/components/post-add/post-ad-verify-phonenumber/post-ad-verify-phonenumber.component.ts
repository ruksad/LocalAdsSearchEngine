import { Component, OnInit, Input, ViewChild, Output, EventEmitter } from '@angular/core';
import { SearchService } from '../../../services/search.service';


@Component({
  selector: 'app-post-ad-verify-phonenumber',
  templateUrl: './post-ad-verify-phonenumber.component.html',
  styleUrls: ['./post-ad-verify-phonenumber.component.css']
})
export class PostAdVerifyPhonenumberComponent implements OnInit {
  @ViewChild('verifyOTPModel') verifyOTPModel;
  @ViewChild('closeOtpModelpopup') closeOtpModelpopup;
  @Output() updateVerifyStatus: EventEmitter<String> = new EventEmitter<any>();


  userPhoneNumber: String;
  otpNumber: Number;
  disableResendAfterOneClick: boolean;
  constructor(private searchService: SearchService) { }

  ngOnInit() {
  }

  otpModel(phoneNumber) {
    this.userPhoneNumber = phoneNumber;
    this.verifyOTPModel.nativeElement.click();
  }

  validateOtp(phoneNumber, otpNumber) {
    this.searchService.verifyOtp(phoneNumber, otpNumber).subscribe(res => {
      this.updateVerifyStatus.emit('validate_sucess');
      this.closeOtpModelpopup.nativeElement.click();
      console.log("otp verification", res);
    }, err => {
      console.log('error')
    })
  }
  resendOtp(phoneNumber) {
    this.disableResendAfterOneClick = true; 
     this.searchService.generateOtp(phoneNumber).subscribe(res => {
        console.log("mobile otp is send successfully");
      }, err => {
        console.log('error')
      })
  }

  

}
