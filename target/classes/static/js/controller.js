angular.module("myapp.controllers", [])
            .controller("myappcontroller", function($scope,$http) {
            	
            	$http.get('/workers')
        		.success(function(data, status, headers, config) {
        				
        			if(status == "200"){
        				$scope.workerLists=data;
        			}
        		})
        		.error(function(data, status, headers, config) {
        			$scope.workerLists = "Unsuccessful";
        		});
            	
            	
            	$scope.selectWorker = function(item){
            		
            		$scope.tableView = true;
            		$http.get('/jobmatcher/'+item.userId)
            		.success(function(data, status, headers, config) {
            			
            			if(status == "200"){
            				$scope.reportData=data;
            				
            			}
            			
            		})
            		.error(function(data, status, headers, config) {
            			$scope.reportData = "Unsuccessful";
            		});
            	};
            	
            	
});