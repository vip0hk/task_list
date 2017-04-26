var boardModule = angular.module("boardModule", []);

/** 登录 */
boardModule.controller('BoardController', 
	['$scope', '$http', '$state','$location', '$stateParams', '$rootScope', 
	function($scope, $http, $state, $location, $stateParams, $rootScope) {
		
		function init(){
			$http.get(getUrl() + '/boards')
	        .success(function(result){
	        	
	            if(result){
	                $scope.boards = result;
	            }
	        })
		}
		init();
		
		// 打开任务列表
	   $scope.toJobBoxs = function(boardId){
		   $state.go('jobBoxs',{'id':boardId});
	   }
		
		$scope.isShow = false;
		
		// 显示创建窗口
		$scope.showPop = function(){
			$scope.isShow = true;
		}
    
		// 关闭
	   $scope.closePop = function(){
		   $scope.isShow = false;
	   }
	   
	   $scope.board ={boardId:'',boardName:''};
	   
	   // 保存
	   $scope.save = function(){
		   
		   $http.post(getUrl() + '/boards/add',$scope.board)
	        .success(function(result){
	        	
	            if(result){
	            	$scope.isShow=false;
	                init();
	            }
	        })
	   }
    
}]);
