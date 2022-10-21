ef self.task_d(group)
      print 'TASK D:---------------------------------------------------------------------', "\n"
      students.select {|student| student.group == group}.each do
         |student| puts 'student : '+student.to_s
      end
   end