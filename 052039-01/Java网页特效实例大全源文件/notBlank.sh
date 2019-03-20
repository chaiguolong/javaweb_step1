ls *.htm | while read file; do
old_file_name=${file}
new_file_name=`echo ${old_file_name} | tr -d ' '`
mv "${old_file_name}" "${new_file_name}"
done
