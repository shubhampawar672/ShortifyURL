import { Component, OnInit } from '@angular/core';
import { UrlserviceService } from '../urlservice.service';
import { url } from '../urlModel';
import { Clipboard } from '@angular/cdk/clipboard';
import { Router } from '@angular/router';

@Component({
  selector: 'app-url-shortner',
  templateUrl: './url-shortner.component.html',
  styleUrls: ['./url-shortner.component.css']
})
export class UrlShortnerComponent {
  longUrl: string='';
  shortUrl: string='';
  Lurl:url =new url();
  constructor( private urlserviceService:UrlserviceService,private clipboard:Clipboard) {}

   getShortUrl(){
    this.Lurl.originalUrl=this.longUrl;
    this.urlserviceService.getUrl(this.Lurl).subscribe(
      (data) => {
        console.log(data);
        this.shortUrl=data.shortUrl;
        
      },
      (error) => console.log(error)
    );
    
  }
  copyToClipboard(){
    this.clipboard.copy(this.shortUrl);
  }
  gotooriginal()
  {
    window.open(this.longUrl, '_blank');
    
  }
}
