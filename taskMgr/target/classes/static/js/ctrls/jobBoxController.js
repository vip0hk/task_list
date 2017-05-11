var jobBoxModule = angular.module("jobBoxModule", ['ng-sortable']);

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
		
		
		// 列表的排序
		$scope.listConfig = { group: 'list', animation: 150 ,handle: ".list-handle",

			// 触发排序
				onEnd:function(item){
//					console.log('被移动之后')
					
					var param = {
						'list':angular.toJson(item.models)
					};
					
					$http.post(getUrl() + '/jobBoxs/sort1', param)
			        .success(function(result){
			        });
					
//					console.log(item)
				}
		};
		
		// 每个任务项目的排序
		$scope.sortableConfig = { group: 'job', animation: 150 ,

			// 1,移除当前元素
			onRemove:function(item){
				item.models.splice(item.oldIndex,1);
			},
			
			// 2,从别的组添加过来
			onAdd:function(item){
				console.log('被添加之后')
				console.log(item)
				
				// 哪个工作
				var oldJobId = item.model.jobId;
				
				// 移动到哪个列表
				var toListId;
				item.models.forEach(function(ele,index){
			 		if (index != item.newIndex) {
			 			toListId = ele.listId;
			 			return false;
			 		}
			 	});
				
				// 移动之后的列表
				var toList = item.models;
				var param = {
					'oldJobId':oldJobId,
					'toListId':toListId,
					'toList':angular.toJson(toList)
				};
				
				$http.post(getUrl() + '/jobs/sort2', param)
		        .success(function(result){
		        });
				
			},
			
			// 3,触发排序
			onEnd:function(item){
				console.log('被移动之后')
//				item.model.listId;
//				item.models
				
				var param = {
					'fromList':angular.toJson(item.models)
				};
				
				$http.post(getUrl() + '/jobs/sort3', param)
		        .success(function(result){
		        });
				
//				console.log(item)
			}
	
			
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
