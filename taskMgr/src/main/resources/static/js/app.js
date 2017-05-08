var taskApp = angular.module('taskApp', ['ui.router','appModule','loginModule',
                                         'leftModule', 'boardModule','jobBoxModule'
                                         ]);

/**
 * 由于整个应用都会和路由打交道，所以这里把$state和$stateParams这两个对象放到$rootScope上，方便其它地方引用和注入。
 * 这里的run方法只会在angular启动的时候运行一次。
*/
taskApp.run(function($rootScope, $state, $stateParams, $http, $location) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;

    //前台拦截
    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams,$scope) {
      $http.get(getUrl() + '/loginUser').success(
    	function(user) {
          if(user){
              $rootScope.islogined = true;
              $rootScope.user = user;
          }
          else{
              $state.go('login');
          }
      });
    });
})

/**
 * 配置路由序列化请求参数
 */
taskApp.config(function($stateProvider, $urlRouterProvider, $httpProvider) {
    $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    $httpProvider.defaults.withCredentials = true;
    $httpProvider.defaults.transformRequest = [function(data) {
        /**
         * The workhorse; converts an object to x-www-form-urlencoded serialization.
         * @param {Object} obj
         * @return {String}
         */
        var param = function(obj) {
            var query = '';
            var name, value, fullSubName, subName, subValue, innerObj, i;
            for (name in obj) {
                value = obj[name];
                if (value instanceof Array) {
                    for (i = 0; i < value.length; ++i) {
                        subValue = value[i];
                        fullSubName = name + '[' + i + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value instanceof Object) {
                    for (subName in value) {
                        subValue = value[subName];
                        fullSubName = name + '[' + subName + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value !== undefined && value !== null) {
                    query += encodeURIComponent(name) + '='
                        + encodeURIComponent(value) + '&';
                }
            }
            return query.length ? query.substr(0, query.length - 1) : query;
        };
        return angular.isObject(data) && String(data) !== '[object File]'
            ? param(data)
            : data;
    }];
//    var interceptor = function($q,$rootScope){
//        return {
//            'responseError':function(rejection){
//                $rootScope.islogin = false;
//                $rootScope.$broadcast("islogin");
//                return $q.reject(rejection);
//            }
//        };
//    };
////    $httpProvider.interceptors.push(interceptor);

    $urlRouterProvider.otherwise('/login') ;
    $stateProvider
    
    	//登录页
        .state('login', {
            url: '/login',
            views:{
            	'left':{
            		template:''
            	},
            	'main':{
            		templateUrl: 'views/login.html'
            	}
            }
        })
        
        /*----------------------------------------------------模块分割线------------------------------------------*/
        //白板列表
        .state('boards', {
        	url:'/boards',
        	views:{
        		'left':{
        			templateUrl:'views/left.html'
        		},
		        'main':{
		        	templateUrl: 'views/boards.html'
		        }
        	}
        })
       
        /*----------------------------------------------------模块分割线------------------------------------------*/
        //任务盒列表
        .state('jobBoxs', {
        	url:'/boards/:id/jobBoxs',
        	views:{
        		'left':{
        			templateUrl:'views/left.html'
        		},
		        'main':{
		        	templateUrl: 'views/jobBoxs.html'
		        }
        	}
        })
        
});