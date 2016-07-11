function addTaskToHtml(task) {
    if (task) {

        var $element = $(Mustache.render(taskTemplate, task));

        if (task.isDone == true) {
            $element.removeClass("activeTask");
            $element.addClass("completedTask");
        }
        $element.click(function () {

                $element.toggleClass("activeTask");
                $element.toggleClass("completedTask");


                for (var i = 0, len = tasks.length; i < len; i++) {
                    if (tasks[i].id == $element.attr("data-id")) {
                        tasks[i].isDone = !tasks[i].isDone;
                    }
                }
                localStorage.todoList = JSON.stringify(tasks);

            }
        );
        $("#frmTasks").append($element);
    }
}



var tasks = [];


if (localStorage.todoList) {
   
     tasks = JSON.parse(localStorage.todoList);
}



var taskTemplate = $("#tmplTask").html();
console.log(taskTemplate);
console.log(tasks);

for (var i = 0; i < tasks.length; i++) {

    addTaskToHtml(tasks[i]);


}


$("#btAddTask").click(function () {

    taskDesc = $("#inNewTask").val().trim();
    if (taskDesc && taskDesc.length > 0) {
        var newTask = {
            id: Date.now(),
            task: taskDesc,
            isDone: false
        }

        addTaskToHtml(newTask);
        tasks.push(newTask);
        localStorage.todoList = JSON.stringify(tasks);
        
        console.log(tasks);
    }
})

$("#btRemCmpl").click(function () {
    $(".completedTask").remove();

    tasks = tasks.filter(function (task) {
        return !task.isDone;
       
    });
    localStorage.todoList = JSON.stringify(tasks);
    console.log(tasks);
})






































