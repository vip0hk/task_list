var jobBoxModule = angular.module("jobBoxModule", []);

var pF =[];
/** 登录 */
jobBoxModule.controller('JobBoxController', 
	['$scope', '$http', '$state','$location', '$stateParams', '$rootScope', 
	function($scope, $http, $state, $location, $stateParams, $rootScope) {

		$scope.isShowWin = false;
		$scope.isShowDate = false;
		$scope.isShowLabel = false;
		
		var boardId = $stateParams.id;
		
		$scope.jobBox = {
					'listTitle':'',
					'boardId':boardId,	
				};
		
		// 取全部的job列表及jobinfo
		function init(){
			$http.get(getUrl() + '/jobBoxs/board/'+boardId)
	        .success(function(result){
	        	
	            if(result){
	                $scope.jobBoxs = result;
	            }
	        })
		}
		
		// 取全部的job列表及jobinfo
		init();
		
		/** 排序后 */
		$scope.onSorted = function($item, $partFrom, $partTo, $indexFrom, $indexTo) {
			console.log('排之后：');
			console.log($item);
			console.log($partFrom);
			console.log($partTo);
			console.log($indexFrom);
			console.log($indexTo);
			var listTo;
			if($indexTo === 0 ){
				listTo = $partTo[1].listId;
			}else{
				listTo = $partTo[0].listId;
			}
			var param = {'jobId':$item.jobId,
						'listFrom':pF[0].listId,
						'listTo':listTo,
						'from':$indexFrom + 1,
						'to':$indexTo + 1};
			$http.post(getUrl() + '/jobs/sort', param)
	        .success(function(result){
	        	
//	            if(result){
//	                init();
//	            }
	        });
		};
		
//		var pF = [];

		/** 开始排序 */
		$scope.onStarted = function($index, $item, $helper, $part) {
			console.log('开始：');
			pF = $part;
			console.log(arguments);
		};
		
		/** 显示新增画面 */
		$scope.showNewWin = function(listId) {
			$scope.isShowWin = true;
			$scope.newJob.listId = listId;
			$scope.newJob.jobId = '';
			$scope.newJob.jobTitle = '';
			$scope.newJob.jobDesc = '';
		};
		/** 显示编辑画面 */
		$scope.showEditWin = function(job) {
			$scope.isShowWin = true;
			$scope.newJob = job;
		};
		/** 关闭编辑画面 */
		$scope.closeWin = function() {
			$scope.isShowWin = false;
		};
		
		/** 显示时间窗口 */
		$scope.showDate = function() {
			$scope.isShowDate = true;
		};
		/** 显示标签窗口 */
		$scope.showLabel = function() {
			$scope.isShowLable = true;
		};
		
		/** 新加列表 */
		$scope.saveList = function() {
			
			$http.post(getUrl() + '/jobBoxs/add', $scope.jobBox)
	        .success(function(result){
	        	
	            if(result){
	            	// 取全部的job列表及jobinfo
	                init();
	                $scope.jobBox.listTitle='';
	            }
	        });
		}
		
		$scope.newJob = {'jobTitle':'', 'jobDesc':''};
		
		// 添加新的jobinfo
		$scope.saveJob = function() {
			
			$http.post(getUrl() + '/jobs/add', $scope.newJob)
	        .success(function(result){
	        	
	            if(result){
	            	// 取全部的job列表及jobinfo
	                init();
	                $scope.isShowWin = false;
	                $scope.isShowWinMin = false;
	            }
	        });
		}
		
		
		/** 显示新增画面Min */
		$scope.showNewWinMin = function(listId) {
			$scope.isShowWinMin = true;
			$scope.listIdShow = listId;
			$scope.newJob.listId = listId;
			$scope.newJob.jobId = '';
			$scope.newJob.jobTitle = '';
			$scope.newJob.jobDesc = '';
		};
		
		$scope.closeNewWinMin = function(){
			$scope.isShowWinMin = false;
		}
		
}]);
