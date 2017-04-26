var loginModule = angular.module("loginModule", []);

/** 登录 */
loginModule.controller('LoginController', 
	['$scope', '$http', '$state','$location', '$stateParams', '$rootScope',
	function($scope, $http, $state, $location, $stateParams, $rootScope) {
    
    $scope.query = {username: '', password: ''};
    $scope.loginErr = false;
    $rootScope.isLogined = false;
    
    //登录按钮
    $scope.login = function(){
    	
        $http.post(getUrl() + '/login',$scope.query)
        .success(function(user){
        	
            if(user){
            	$rootScope.isLogined = true;
        	    $rootScope.user = {name:'hk'};
            	$state.go('boards');
//            	$state.go('jobBoxs');
            }
            else{
            	// 账号或密码错误
            	$scope.loginErr = true;
            }
        })
    }
    
    //登录回车事件
    $scope.loginKeyPress = function(event){
        if(event.keyCode == 13){
            $scope.login()
        }
    }
    
}]);
