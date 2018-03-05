package com.jason_sunyf.moudlewhether.entity

/**
 *
 * @author Jason_Sunyf
 * @date 2017/12/13 0013
 * Email： jason_sunyf@163.com
 */

class WhetherByCity {

    /**
     * sk : {"temp":"-1","wind_direction":"北风","wind_strength":"3级","humidity":"73%","time":"01:08"}
     * today : {"temperature":"-2℃~3℃","weather":"小雪转阴","weather_id":{"fa":"14","fb":"02"},"wind":"微风","week":"星期四","city":"郑州","date_y":"2017年12月14日","dressing_index":"冷","dressing_advice":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。","uv_index":"最弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
     * future : {"day_20171214":{"temperature":"-2℃~3℃","weather":"小雪转阴","weather_id":{"fa":"14","fb":"02"},"wind":"微风","week":"星期四","date":"20171214"},"day_20171215":{"temperature":"-1℃~8℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东北风微风","week":"星期五","date":"20171215"},"day_20171216":{"temperature":"-3℃~7℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西北风微风","week":"星期六","date":"20171216"},"day_20171217":{"temperature":"-4℃~9℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风微风","week":"星期日","date":"20171217"},"day_20171218":{"temperature":"-4℃~9℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风微风","week":"星期一","date":"20171218"},"day_20171219":{"temperature":"-4℃~9℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风微风","week":"星期二","date":"20171219"},"day_20171220":{"temperature":"-3℃~7℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西北风微风","week":"星期三","date":"20171220"}}
     */

    var sk: SkBean? = null
    var today: TodayBean? = null
    var future: FutureBean? = null

    class SkBean {
        /**
         * temp : -1
         * wind_direction : 北风
         * wind_strength : 3级
         * humidity : 73%
         * time : 01:08
         */

        var temp: String? = null
        var wind_direction: String? = null
        var wind_strength: String? = null
        var humidity: String? = null
        var time: String? = null
    }

    class TodayBean {
        /**
         * temperature : -2℃~3℃
         * weather : 小雪转阴
         * weather_id : {"fa":"14","fb":"02"}
         * wind : 微风
         * week : 星期四
         * city : 郑州
         * date_y : 2017年12月14日
         * dressing_index : 冷
         * dressing_advice : 天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。
         * uv_index : 最弱
         * comfort_index :
         * wash_index : 不宜
         * travel_index : 较不宜
         * exercise_index : 较不宜
         * drying_index :
         */

        var temperature: String? = null
        var weather: String? = null
        var weather_id: WeatherIdBean? = null
        var wind: String? = null
        var week: String? = null
        var city: String? = null
        var date_y: String? = null
        var dressing_index: String? = null
        var dressing_advice: String? = null
        var uv_index: String? = null
        var comfort_index: String? = null
        var wash_index: String? = null
        var travel_index: String? = null
        var exercise_index: String? = null
        var drying_index: String? = null

        class WeatherIdBean {
            /**
             * fa : 14
             * fb : 02
             */

            var fa: String? = null
            var fb: String? = null
        }
    }

    class FutureBean {
        /**
         * day_20171214 : {"temperature":"-2℃~3℃","weather":"小雪转阴","weather_id":{"fa":"14","fb":"02"},"wind":"微风","week":"星期四","date":"20171214"}
         * day_20171215 : {"temperature":"-1℃~8℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东北风微风","week":"星期五","date":"20171215"}
         * day_20171216 : {"temperature":"-3℃~7℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西北风微风","week":"星期六","date":"20171216"}
         * day_20171217 : {"temperature":"-4℃~9℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风微风","week":"星期日","date":"20171217"}
         * day_20171218 : {"temperature":"-4℃~9℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风微风","week":"星期一","date":"20171218"}
         * day_20171219 : {"temperature":"-4℃~9℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风微风","week":"星期二","date":"20171219"}
         * day_20171220 : {"temperature":"-3℃~7℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西北风微风","week":"星期三","date":"20171220"}
         */
        var day_20171214: Day20171214Bean? = null
        var day_20171215: Day20171215Bean? = null
        var day_20171216: Day20171216Bean? = null
        var day_20171217: Day20171217Bean? = null
        var day_20171218: Day20171218Bean? = null
        var day_20171219: Day20171219Bean? = null
        var day_20171220: Day20171220Bean? = null

        class Day20171214Bean {
            /**
             * temperature : -2℃~3℃
             * weather : 小雪转阴
             * weather_id : {"fa":"14","fb":"02"}
             * wind : 微风
             * week : 星期四
             * date : 20171214
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBeanX? = null
            var wind: String? = null
            var week: String? = null
            var date: String? = null

            class WeatherIdBeanX {
                /**
                 * fa : 14
                 * fb : 02
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }

        class Day20171215Bean {
            /**
             * temperature : -1℃~8℃
             * weather : 多云
             * weather_id : {"fa":"01","fb":"01"}
             * wind : 东北风微风
             * week : 星期五
             * date : 20171215
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBeanXX? = null
            var wind: String? = null
            var week: String? = null
            var date: String? = null

            class WeatherIdBeanXX {
                /**
                 * fa : 01
                 * fb : 01
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }

        class Day20171216Bean {
            /**
             * temperature : -3℃~7℃
             * weather : 晴
             * weather_id : {"fa":"00","fb":"00"}
             * wind : 西北风微风
             * week : 星期六
             * date : 20171216
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBeanXXX? = null
            var wind: String? = null
            var week: String? = null
            var date: String? = null

            class WeatherIdBeanXXX {
                /**
                 * fa : 00
                 * fb : 00
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }

        class Day20171217Bean {
            /**
             * temperature : -4℃~9℃
             * weather : 多云
             * weather_id : {"fa":"01","fb":"01"}
             * wind : 西风微风
             * week : 星期日
             * date : 20171217
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBeanXXXX? = null
            var wind: String? = null
            var week: String? = null
            var date: String? = null

            class WeatherIdBeanXXXX {
                /**
                 * fa : 01
                 * fb : 01
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }

        class Day20171218Bean {
            /**
             * temperature : -4℃~9℃
             * weather : 多云
             * weather_id : {"fa":"01","fb":"01"}
             * wind : 西风微风
             * week : 星期一
             * date : 20171218
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBeanXXXXX? = null
            var wind: String? = null
            var week: String? = null
            var date: String? = null

            class WeatherIdBeanXXXXX {
                /**
                 * fa : 01
                 * fb : 01
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }

        class Day20171219Bean {
            /**
             * temperature : -4℃~9℃
             * weather : 多云
             * weather_id : {"fa":"01","fb":"01"}
             * wind : 西风微风
             * week : 星期二
             * date : 20171219
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBeanXXXXXX? = null
            var wind: String? = null
            var week: String? = null
            var date: String? = null

            class WeatherIdBeanXXXXXX {
                /**
                 * fa : 01
                 * fb : 01
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }

        class Day20171220Bean {
            /**
             * temperature : -3℃~7℃
             * weather : 晴
             * weather_id : {"fa":"00","fb":"00"}
             * wind : 西北风微风
             * week : 星期三
             * date : 20171220
             */

            var temperature: String? = null
            var weather: String? = null
            var weather_id: WeatherIdBeanXXXXXXX? = null
            var wind: String? = null
            var week: String? = null
            var date: String? = null

            class WeatherIdBeanXXXXXXX {
                /**
                 * fa : 00
                 * fb : 00
                 */

                var fa: String? = null
                var fb: String? = null
            }
        }
    }
}
