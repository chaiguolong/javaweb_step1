if exists("g:vimlayoutloaded")
    finish
else
    let g:vimlayoutloaded=1
endif

function! HeightToSize(height)
    let currwinno=winnr()
        if winheight(currwinno)>a:height
            while winheight(currwinno)>a:height
                execute "normal \<c-w>-"
            endwhile
        elseif winheight(currwinno)<a:height
            while winheight(currwinno)<a:height
                execute "normal \<c-w>+"
            endwhile
        endif
endfunction

function! WidthToSize(width)
       let currwinno=winnr()
        if winwidth(currwinno)>a:width
            while winwidth(currwinno)>a:width
                execute "normal \<c-w><"
            endwhile
        elseif winwidth(currwinno)<a:width
            while winwidth(currwinno)<a:width
                execute "normal \<c-w>>"
            endwhile
        endif
endfunction


function! TweakWinSize(orgisize)
    call HeightToSize(a:orgisize[0])
    call WidthToSize(a:orgisize[1])
endfunction

function! RestoreWinLayout()
    if exists("g:layout")
        let winno=1
        let orgiwinno=winnr()
        for win in g:layout
            execute "normal \<c-w>w"
            let currwinno=winnr()
            if currwinno!=1 && currwinno!=orgiwinno
                call TweakWinSize(g:layout[currwinno-1])
            endif
        endfor
        unlet g:layout
    endif
endfunction

function! SaveWinLayout()
    let wnumber=winnr("$")
    let winlist=range(wnumber)
    let winno=0
    let layout=[]
    for index in winlist
        let winno+=1
        let wininfo=[winheight(winno),winwidth(winno)]
        call add(layout,wininfo)
    endfor
    let g:layout=layout
endfunction

function! ToggleMaxWin()
    if exists("g:layout")
        if winnr("$")==len(g:layout)
            call RestoreWinLayout()
        else
            call SaveWinLayout()
            execute "normal 200\<c-w>>"
            execute "normal \<c-w>_"
            call RestoreWinLayout()
        endif
    else
        call SaveWinLayout()
        execute "normal 200\<c-w>>"
        execute "normal \<c-w>_"
    endif
endfunction
