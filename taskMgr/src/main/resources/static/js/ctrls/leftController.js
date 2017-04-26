var leftModule = angular.module("leftModule", []);

/** 登录 */
leftModule.controller('LeftController', 
	['$scope', '$http', '$state','$location', '$stateParams', '$rootScope', 
	function($scope, $http, $state, $location, $stateParams, $rootScope) {
    
		$scope.isShow = false;
		
		//退出按钮
	    $scope.close = function(){
	    	
	       $scope.isShow = true;
	    }
	    
		//退出按钮
	    $scope.close = function(){
	    	
	       $scope.isShow = false;
	    }
    
}]);
