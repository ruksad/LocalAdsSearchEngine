import { Component, OnInit, DoCheck, Input } from '@angular/core';
import { BroadcastDataService } from '../../services/broadcast-data.service';
import { SearchService } from '../../services/search.service';
import { UtilsService } from '../../services/utils.service';
import { LoadExternalApiService } from '../../services/load-external-api.service';
import { NguCarousel, NguCarouselStore } from '@ngu/carousel';

@Component({
  selector: 'app-featured-cards',
  templateUrl: './featured-cards.component.html',
  styleUrls: ['./featured-cards.component.css']
})
export class FeaturedCardsComponent implements OnInit {
  public carouselTile: NguCarousel;

  @Input()
  public allFeaturedCards:any[];
  constructor() { }

  ngOnInit() {
    this.sliderConfiguration();
  }

  sliderConfiguration(){
    this.carouselTile = {
      grid: {xs: 2, sm: 3, md: 3, lg: 4, all: 0},
      slide: 1,
      speed: 100,
      interval: 1000,
      loop:true,
      animation: 'lazy',
      point: {
        visible: true,
        pointStyles: `
          .ngucarouselPoint {
            list-style-type: none;
            text-align: center;
            padding: 12px;
            margin: 0;
            white-space: nowrap;
            overflow: auto;
            box-sizing: border-box;
          }
          .ngucarouselPoint li {
            display: inline-block;
            border-radius: 50%;
            border: 2px solid rgba(0, 0, 0, 0.55);
            padding: 4px;
            margin: 0 3px;
            transition-timing-function: cubic-bezier(.17, .67, .83, .67);
            transition: .4s;
          }
          .ngucarouselPoint li.active {
              background: #6b6b6b;
              transform: scale(1.2);
          }
        `
      },
      load: 2,
      touch: true,
      easing: 'ease'
    }
  }
}
