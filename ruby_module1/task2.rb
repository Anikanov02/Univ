class Student
   counter = 0

   attr_reader :id, :name, :surname, :fathers, :date, :address, :phone, :faculty, :course, :group

   def initialize(id, name, surname, fathers, date, address, faculty, phone,  course, group)
      @id = id
      @name = name
      @surname = surname
      @fathers = fathers
      @date = date
      @address = address
      @phone = phone
      @faculty = faculty
      @course = course
      @group = group
   end

   def Student.new_instance(name, surname, fathers, date, address, faculty, phone, course, group)
      Student.new(1, name, surname, fathers, date, address, faculty, phone, course, group)
   end

   def setID(id)
      @id = id
   end

   def setName(name)
      @name = name
   end

   def setSurname(surname)
      @surname = surname
   end

   def setFathers(fathers)
      @fathers = fathers
   end

   #...

   def getId()
      id
   end

   def set()
      name
   end

   def set()
      surname
   end

   def set()
      fathers
   end

   #...

   def to_s
      "Student{\n"\
      "id = #{@id},\n"\
      "name = #{@name},\n"\
      "surname = #{@surname},\n"\
      "fathers = #{@fathers},\n"\
      "address = #{@address},\n"\
      "date = #{@date},\n"\
      "phone = #{@phone},\n"\
      "faculty = #{@faculty},\n"\
      "course = #{@course},\n"\
      "group = #{@group},\n}"
   end

   def Student.students
      [
         Student.new_instance('n0','s0','f0','2000','a0','f1','p0','c0','g1'),
         Student.new_instance('n1','s1','f1','2001','a1','f2','p1','c1','g1'),
         Student.new_instance('n2','s2','f2','2002','a2','f1','p2','c2','g2'),
         Student.new_instance('n3','s3','f3','2003.','a3','f2','p3','c3','g2'),
                Student.new(4,'n4','s4','f4','2007','a4','f1','p4','c3','g1'),
                Student.new(5,'n5','s5','f5','2005','a5','f2','p5','c3','g2'),
                Student.new(6,'n6','s6','f6','2006','a6','f3','p6','c2','g1'),
                Student.new(7,'n7','s7','f7','2007','a7','f4','p7','c1','g2')
      ]
   end

   def self.task_a(faculty)
      print 'TASK A:---------------------------------------------------------------------', "\n"
      students.select {|student| student.faculty == faculty}.each do
         |student| puts 'student : '+student.to_s
      end
   end
   
   def self.task_b()
      print 'TASK B:---------------------------------------------------------------------', "\n"
      students.map{|t| t.faculty}.uniq.each do
         |faculty| 
            puts puts 'FACULTY::::::::::::::::::', faculty
            students.select {|student| student.faculty == faculty}.each do
               |student| puts 'student : '+student.to_s
         end
      end
      students.map{|t| t.course}.uniq.each do
         |course| 
            puts 'COURSE::::::::::::::::::', course
            students.select {|student| student.course == course}.each do
               |student| puts 'student : '+student.to_s
         end
      end
   end
   
   def self.task_c(year)
      print 'TASK C:---------------------------------------------------------------------', "\n"
      students.select{ |student| student.date > year }.each do
         |student| puts 'student : '+student.to_s
      end
   end
   
   def self.task_d(group)
      print 'TASK D:---------------------------------------------------------------------', "\n"
      students.select {|student| student.group == group}.each do
         |student| puts 'student : '+student.to_s
      end
   end
end

print 'TASK 2 : '
print 'a : faculty='
faculty = gets.chomp
print 'c : year='
year = gets.chomp
print 'd : group='
group = gets.chomp
Student.task_a(faculty)
Student.task_b
Student.task_c(year)
Student.task_d(group)