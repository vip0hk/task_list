var appModule = angular.module("appModule", []);

/** 登录 */
appModule.controller('AppController', 
	['$scope', '$http', '$state','$location', '$stateParams', '$rootScope', 
	function($scope, $http, $state, $location, $stateParams, $rootScope) {
    
		$rootScope.isLogined = true;
		
		// 初始化时，从session取出登录用户信息
	    $rootScope.user = {userName:'hk'};
	    $http.get(getUrl() + '/loginUser')
        .success(function(user){
        	
            if(user){
                $rootScope.user = user;
            }
        })
	    
		    
    //退出按钮
    $scope.logout = function(){
    	
        $http.get(getUrl() + '/logout')
        .success(function(result){
        	
            if(result){
                $state.go('login');
            }
        })
    }
    
    
}]);
