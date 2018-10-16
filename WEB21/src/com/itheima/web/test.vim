
let s:Fsep = javaunit#util#Fsep()
let s:Psep = javaunit#util#Psep()

let s:filepath = expand('%:p')

let s:filetype = expand('%:e')
		
let s:cppath = split(s:filepath, "src")[0]

let s:webapp = split(s:cppath,s:Fsep)[4]

let g:JavaUnit_Home = fnamemodify(expand('<sfile>'), ':p:h:h:gs?\\?'. s:Fsep. '?')

let g:haha = expand('<sfile>')

let g:JavaUnit_custom_tempdir = expand('<sfile>')

let s:cppath = split(expand('<sfile>'), "src")[0] + "/build/classes/"

" echom g:JavaUnit_custom_tempdir
"
" echom s:cppath

let g:JavaUnit_custom_tempdir = split(expand('<sfile>'), "src")[0] ."/build/classes/"

if exists("g:JavaUnit_custom_tempdir")
	let s:JavaUnit_tempdir = g:JavaUnit_custom_tempdir
else
	let s:JavaUnit_tempdir = g:JavaUnit_Home .s:Fsep .'bin'
endif



echom g:JavaUnit_custom_tempdir

" echom s:Fsep

" echom g:JavaUnit_Home

" echom s:cppath
"
" echom s:webapp
"
"
" echom getcwd()
"
" echom get(s:,'cppath','.')
