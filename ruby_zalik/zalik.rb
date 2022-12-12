/ Variant 1 /
class LibraryPublication
  attr_accessor :publications

  def initialize(publications)
    @publications = publications
  end

  def add_publication(publication)
    if publications.select { |arr_pub| arr_pub.title.casecmp(publication.title) == 0 }.any?
      return
    end
    publications.push(publication)
  end

  def get_linked_publications(publication)
    publication.links
  end

  def get_publication_by_title(title)
    publications.select { |publication| publication.title.casecmp(title) == 0 }.first
  end

  def get_publications_by_author(author)
    publications.select { |publication| publication.author.casecmp(author) == 0 }
  end

  def get_publications_by_keywords(keywords)
    publications.select do |publication|
      keywords.select do |keyword|
        publication.text.downcase.include?(keyword.downcase)
      end.length == keywords.length
    end
  end

  def sort_publications_by_input(input)
    publications.sort do |pub1, pub2|
      (pub1.title.casecmp input).abs - (pub2.title.casecmp input).abs
    end
  end
end


class Publication
  attr_accessor :title, :author, :text, :links
  def initialize(title, author, text, links)
    @title = title
    @author = author
    @text = text
    @links = links
  end

  def to_s
    "title: #{title}, author: #{author}, text: #{text}\n links: #{links}\n"
  end 
end

class MathPublication < Publication
  attr_accessor :work_name, :univ_name
  def initialize(title, author, text, links, work_name, univ_name)
    super(title, author, text, links)
    @work_name = work_name
    @univ_name = univ_name
  end

  def to_s
    super + "work_name: #{work_name}, univ_name: #{univ_name}\n"
  end 

end

class PhysicsPublication < Publication
  attr_accessor :companions, :scientific_scope
  def initialize(title, author, text, links, companions, scientific_scope)
    super(title, author, text, links)
    @companions = companions
    @scientific_scope = scientific_scope
  end

  def to_s
    super + "companions: #{companions}, scientific scope: #{scientific_scope}\n"
  end 

end

class ChemistryPublication < Publication
  attr_accessor :year, :mentor
  def initialize(title, author, text, links, year, mentor)
    super(title, author, text, links)
    @year = year
    @mentor = mentor
  end

  def to_s
    super + "year: #{year}, mentor: #{mentor}\n"
  end 
end

chemPub = ChemistryPublication.new("title1", "author1", "text1" ,["publication1", "publication2"], 2003, "abobus" )
phyPub = PhysicsPublication.new("title2", "author2", "text2" ,["publication1", "publication2"], ["companion1", "companion1"],"quantum physics")
mathPub = MathPublication.new("title3", "author3", "text3" ,["publication1", "publication2"], "papername1", "KNU")

array = [chemPub, phyPub, mathPub]

print "Publications:"
array.each do |pub|
    puts "#{pub.to_s}\n\n\n"
end


libPublication = LibraryPublication.new(array)

print "\nLinked publications from ChemistryPublication:\n"
puts libPublication.get_linked_publications(chemPub)

print "\nGet publication by title <title3>:\n"
puts libPublication.get_publication_by_title("title3")

print "\nGet publication by author <author2>:\n"
puts libPublication.get_publications_by_author("author2")

print "\nGet publication by keyword <text>:\n"
puts libPublication.get_publications_by_keywords(["text"])

print "\nSort publications by input <title>:\n"
puts libPublication.sort_publications_by_input("title")