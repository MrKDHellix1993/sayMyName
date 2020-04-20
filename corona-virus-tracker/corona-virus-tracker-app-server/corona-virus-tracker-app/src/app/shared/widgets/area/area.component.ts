import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import HC_exporting from 'highcharts/modules/exporting';
import { DashboardService } from '../../services/dashboard.service';

@Component({
  selector: 'app-widget-area',
  templateUrl: './area.component.html',
  styleUrls: ['./area.component.scss']
})
export class AreaComponent implements OnInit {
  constructor(private dashBoardService : DashboardService) { }

  public chartOptions = {};
  public areaDataReport = {};
  public highcharts = Highcharts;
  ngOnInit(): void {
    this.areaDataReport = this.dashBoardService.getDashboardChartData();
    this.chartOptions = {
      chart: {
        type: 'area'
      },
      title: {
        text: 'Global Coronavirus Contry & Region wise Information'
      },
      subtitle: {
        text: 'Source: https://www.who.int/health-topics/coronavirus'
      },
      tooltip: {
        split: true,
        valueSuffix: ' millions'
      },
      credits : {
        enabled : false
      },
      exporting :{
        enabled : true
      },
      series: [ this.areaDataReport]
    };
    HC_exporting(Highcharts);
    
    setTimeout(()=>{
      window.dispatchEvent(
        new Event('resize')
      );
    }, 300);

  }
}
