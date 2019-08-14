require 'json'

package = JSON.parse(File.read(File.join(__dir__, '../', 'package.json')))

Pod::Spec.new do |s|
  s.name         = package['name']
  s.version      = package['version']
  s.summary      = package['description']
  s.license      = package['license']

  s.authors      = package['author']
  s.homepage     = package['homepage']
  s.platform     = :ios, "9.0"

  s.source       = { :git => "https://github.com/exozet/react-native-google-cast.git", :branch => "bugfix/listen-to-on-route-added-even-if-companion-library-doesnt-do" }
  s.source_files  = "./**/*.{h,m}"

  s.dependency 'React'
  s.dependency 'google-cast-sdk', '2.10.4.1'
end