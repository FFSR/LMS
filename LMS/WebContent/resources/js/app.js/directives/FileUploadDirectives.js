App.directive('dropzone', dropzone);

function dropzone() {

    return function(scope, element, attrs) {
    	var getUrl = window.location;
    	var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
    	console.log("Print From File Upload Directive: "+baseUrl+ "/");
        var config = {
        	url: baseUrl+'/upload', 
        		//url: baseUrl+'/fileupload',
        	//url: 'http://localhost:8080/SRMS_2/upload',
        	//url: 'http://10.10.22.20:8280/SRMS_P12/upload',
//        	url: 'http://10.10.21.20:8080/SRMS/upload',
            maxFilesize: 20000,
            paramName: "uploadfile",
            maxThumbnailFilesize: 10,
            parallelUploads: 10,
            autoProcessQueue: false,
            acceptedFiles: ".pdf,.doc,.docx,.msg,.xls,.xlsx,.jpg,.png,.gif,.txt,.csv,.zip,.ppt,.pptx,.eml,.mkv"
        };

        var eventHandlers = {
            'addedfile': function(file) {
                scope.file = file;
                
                if (this.files[10]!=null) {
                    this.removeFile(this.files[9]);
                }
                
                scope.$apply(function() {
                    scope.fileAdded = true;
                });
            },

            'success': function (file, response) {
            }
        };

        dropzone = new Dropzone(element[0], config);

        angular.forEach(eventHandlers, function(handler, event) {
            dropzone.on(event, handler);
        });

        scope.processDropzone = function() {
        	console.log("File Count: ", dropzone.files.length);
            dropzone.processQueue();
        };

        scope.resetDropzone = function() {
            dropzone.removeAllFiles();
            dropzone.on("complete", function(file) {
            	dropzone.removeFile(file);
            	});
        }
    }
}

