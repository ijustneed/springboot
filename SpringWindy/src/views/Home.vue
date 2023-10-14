<template>
  <div>
    <h1 style="text-align: center;padding-bottom: 10px;font-size: 50px">欢迎来到后台管理系统</h1>
    <el-row >
      <el-col :span="12">
        <div id="main" style="width: 500px;height: 400px"></div>
      </el-col>
      <el-col :span="12">
        <div id="pie" style="width: 500px;height: 400px"></div>
      </el-col>
    </el-row>


  </div>

</template>

<script>
import * as echarts from "echarts"
export default {
  name: "Home",
  data() {
    return{

    }
  },
  created() {


  },
  methods:{

  },
  mounted() {

    var option;

    option = {
      title: {
        text: '各季度注册用户统计',
        subtext: '趋势图',
        left:'center'

      },
      xAxis: {
        type: 'category',
        data: ["第一季度","第二季度","第三季度","第四季度"]
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [],
          type: 'line'
        },
        {
          data: [],
          type: 'bar'
        },

      ]
    };
    var pieOption = {
      title: {
        text: '各季度注册用户统计',
        subtext: '比例图',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      series: [
        {
          // name: 'Access From',
          type: 'pie',
          radius: '50%',
          data: [],
          label: {
            //echarts饼图内部显示百分比设置
            show: true,
            position: "inside", //outside 外部显示  inside 内部显示
            formatter: `{d}%`,
            color: "#ffffff", //颜色
            fontSize: 12 //字体大小
          },
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };

    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);

    var pieDom = document.getElementById('pie');
    var pieChart = echarts.init(pieDom);

    this.request.get("/echarts/members").then(res=>{
      // option.xAxis.data = res.data.x
      option.series[0].data = res.data
      option.series[1].data = res.data
      myChart.setOption(option)



      pieOption.series[0].data = [
        {name: "第一季度", value: res.data[0]},
        {name: "第二季度", value: res.data[1]},
        {name: "第三季度", value: res.data[2]},
        {name: "第四季度", value: res.data[3]},
      ]
      pieChart.setOption(pieOption)
    })





  }
}
</script>

<style scoped>

</style>
